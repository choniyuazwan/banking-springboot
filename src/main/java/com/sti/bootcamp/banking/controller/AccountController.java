package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.AccountDao;
import com.sti.bootcamp.banking.db.dao.TransactionDao;
import com.sti.bootcamp.banking.db.model.*;
import com.sti.bootcamp.banking.db.repository.AccountRepository;
import com.sti.bootcamp.banking.exception.CustomException;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    public static final String URL_REQUEST_ACCOUNT = "/account";
    public static final String URL_REQUEST_ACCOUNT_LIST = "/accounts";
    public static final String URL_REQUEST_ACCOUNT_BY_ID = "/account/{id}";

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(value = URL_REQUEST_ACCOUNT_BY_ID)
    public CommonResponse<AccountEntity> getAccountEntity(@PathVariable(name = "id") String id) throws CustomException {
        AccountEntity account = accountDao.getById(Integer.parseInt(id));
        CommonResponse<AccountEntity> response = new CommonResponse<>();
        if (account == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(account);
        }
        return response;
    }

    @PostMapping(value = URL_REQUEST_ACCOUNT)
    public CommonResponse<AccountEntity> createAccountEntity(@RequestBody AccountEntity account) {
        CommonResponse<AccountEntity> response = new CommonResponse<>();
        response.setData(accountDao.save(account));
        return response;

//        CommonResponse<AccountEntity> response = new CommonResponse<>();
//        response.setData(accountDao.save(account));
//
//        TransactionEntity transaction = new TransactionEntity();
//        TransactionTypeEntity transactionType = new TransactionTypeEntity();
//        transactionType.setCode(1);
//
//        CustomerEntity customer = new CustomerEntity();
//        customer.setCif(account.getCustomer().getCif());
//
//        transaction.setTransactionType(transactionType);
//        transaction.setAccountDebit(account);
//        transaction.setAmount(account.getBalance());
//        transaction.setDate(account.getOpenDate());
//        transaction.setCustomer(customer);
//
//
//        transactionDao.save(transaction);
//        return response;
    }

    @PatchMapping(value=URL_REQUEST_ACCOUNT)
    public CommonResponse<AccountEntity> updateAccountEntity(@RequestBody AccountEntity account) throws CustomException {
        AccountEntity checkAccount = accountDao.getById(account.getAccountNumber());
        CommonResponse<AccountEntity> response = new CommonResponse<>();
        if(checkAccount==null) {
            throw new CustomException("404", "Not Found");
        }else{
            response.setData(accountDao.save(account));
        }
        return response;
    }

    @GetMapping(value=URL_REQUEST_ACCOUNT_LIST)
    public CommonResponse<List<AccountEntity>> getAccountList(@RequestParam(name="cif", defaultValue="") String cif) {
        List<AccountEntity> list;
        list = accountDao.getList(Integer.parseInt(cif));

        CommonResponse<List<AccountEntity>> resp = new CommonResponse<>();
        resp.setData(list);
        return resp;
    }

    @DeleteMapping(URL_REQUEST_ACCOUNT_BY_ID)
    public CommonResponse<AccountEntity> delete(@PathVariable(name = "id") String id) throws CustomException {
//        CommonResponse<AccountEntity> response = new CommonResponse<AccountEntity>();
//        AccountEntity checkAccount = accountDao.getById(Integer.parseInt(id));
//        if(checkAccount==null) {
//            throw new CustomException("404", "Not Found");
//        }else{
//            response.setData(accountRepository.deleteById(Integer.parseInt(id)));
//        }
//        return response;

        CommonResponse<AccountEntity> response = new CommonResponse<AccountEntity>();
        AccountEntity checkAccount = accountDao.getById(Integer.parseInt(id));
        if(checkAccount==null) {
            throw new CustomException("404", "Not Found");
        }else{
            try {
                response.setData(accountRepository.deleteById(Integer.parseInt(id)));
            } catch (Exception e) {
                throw new CustomException("500", "This record cannot be deleted because it used by other table");
            }
        }
        return response;
    }
}