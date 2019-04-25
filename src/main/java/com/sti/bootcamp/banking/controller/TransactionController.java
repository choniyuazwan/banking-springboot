package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.AccountDao;
import com.sti.bootcamp.banking.db.dao.TransactionDao;
import com.sti.bootcamp.banking.db.model.AccountEntity;
import com.sti.bootcamp.banking.db.model.TransactionEntity;
import com.sti.bootcamp.banking.exception.CustomException;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sti.bootcamp.banking.controller.AccountController.URL_REQUEST_ACCOUNT;

@RestController
public class TransactionController {
    public static final String URL_REQUEST_TRANSACTION = "/transaction";
    public static final String URL_REQUEST_TRANSACTION_LIST = "/transactions";
    public static final String URL_REQUEST_TRANSACTION_BY_ID = "/transaction/{id}";

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private AccountDao accountDao;

    @GetMapping(value = URL_REQUEST_TRANSACTION_BY_ID)
    public CommonResponse<TransactionEntity> getTransactionEntity(@PathVariable(name = "id") String id) throws CustomException {
        TransactionEntity transaction = transactionDao.getById(Integer.parseInt(id));
        CommonResponse<TransactionEntity> response = new CommonResponse<>();
        if (transaction == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(transaction);
        }
        return response;
    }

    @PostMapping(value = URL_REQUEST_TRANSACTION)
    public CommonResponse<TransactionEntity> createTransactionEntity(@RequestBody TransactionEntity transaction) throws CustomException {
        CommonResponse<TransactionEntity> response = new CommonResponse<>();
        AccountEntity checkAccountDebit = accountDao.getById(transaction.getAccountDebit().getAccountNumber());

        if(transaction.getTransactionType().getCode()==1) {
            int newBalanceDebit = checkAccountDebit.getBalance() + transaction.getAmount();
            checkAccountDebit.setBalance(newBalanceDebit);
            accountDao.save(checkAccountDebit);
            response.setData(transactionDao.save(transaction));
        } else if(transaction.getTransactionType().getCode()==2) {
            AccountEntity checkAccountCredit = accountDao.getById(transaction.getAccountCredit().getAccountNumber());
            if(checkAccountCredit==null) {
                throw new CustomException("404", "Not Found");
            }

            int newBalanceDebit = checkAccountDebit.getBalance() - transaction.getAmount();
            int newBalanceCredit = checkAccountCredit.getBalance() + transaction.getAmount();

            checkAccountDebit.setBalance(newBalanceDebit);
            checkAccountCredit.setBalance(newBalanceCredit);
            accountDao.save(checkAccountDebit);
            accountDao.save(checkAccountCredit);

            response.setData(transactionDao.save(transaction));
        } else if(transaction.getTransactionType().getCode()==3) {
            int newBalanceDebit = checkAccountDebit.getBalance() - transaction.getAmount();
            checkAccountDebit.setBalance(newBalanceDebit);
            accountDao.save(checkAccountDebit);
            response.setData(transactionDao.save(transaction));
        }
        return response;
    }

    @GetMapping(value=URL_REQUEST_TRANSACTION_LIST)
    public CommonResponse<List<TransactionEntity>> getAccountList(@RequestParam(name="cif", defaultValue="") String cif) {
        List<TransactionEntity> list;
        list = transactionDao.getList(Integer.parseInt(cif));

        CommonResponse<List<TransactionEntity>> resp = new CommonResponse<>();
        resp.setData(list);
        return resp;
    }
}
