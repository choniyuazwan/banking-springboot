package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.AccountDao;
import com.sti.bootcamp.banking.db.model.AccountEntity;
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
    }

    @PutMapping(value=URL_REQUEST_ACCOUNT)
    public CommonResponse<AccountEntity> updateAccountEntity(@RequestBody AccountEntity account) throws CustomException {
        AccountEntity checkAccount = accountDao.getById(account.getAccountNumber());
        CommonResponse<AccountEntity> response = new CommonResponse<>();
        if(checkAccount==null) {
            throw new CustomException("404", "Not Found");
        }else{
            response.setData(accountDao.save(checkAccount));
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
}
