package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.WalletAccountDao;
import com.sti.bootcamp.banking.db.model.WalletAccountEntity;
import com.sti.bootcamp.banking.db.repository.WalletAccountRepository;
import com.sti.bootcamp.banking.exception.CustomException;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletAccountController {
    public static final String URL_REQUEST_WALLET_ACCOUNT = "/walletaccount";
    public static final String URL_REQUEST_WALLET_ACCOUNT_LIST = "/walletaccounts";
    public static final String URL_REQUEST_WALLET_ACCOUNT_BY_ID = "/walletaccount/{id}";

    @Autowired
    private WalletAccountDao walletAccountDao;

    @Autowired
    private WalletAccountRepository walletAccountRepository;

    @GetMapping(value = URL_REQUEST_WALLET_ACCOUNT_BY_ID)
    public CommonResponse<WalletAccountEntity> getWalletAccountEntity(@PathVariable(name = "id") String id) throws CustomException {
        WalletAccountEntity walletAccount = walletAccountDao.getById(Integer.parseInt(id));
        CommonResponse<WalletAccountEntity> response = new CommonResponse<>();
        if (walletAccount == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(walletAccount);
        }
        return response;
    }

    @PostMapping(value = URL_REQUEST_WALLET_ACCOUNT)
    public CommonResponse<WalletAccountEntity> createWalletAccountEntity(@RequestBody WalletAccountEntity walletAccount) {
        CommonResponse<WalletAccountEntity> response = new CommonResponse<>();
        response.setData(walletAccountDao.save(walletAccount));
        return response;
    }

    @PutMapping(value = URL_REQUEST_WALLET_ACCOUNT)
    public CommonResponse<WalletAccountEntity> updateWalletAccountEntity(@RequestBody WalletAccountEntity walletAccount) throws CustomException {
        WalletAccountEntity checkAccount = walletAccountDao.getById(walletAccount.getId());
        CommonResponse<WalletAccountEntity> response = new CommonResponse<>();
        if (checkAccount == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(walletAccountDao.save(checkAccount));
        }
        return response;
    }

    @GetMapping(value = URL_REQUEST_WALLET_ACCOUNT_LIST)
    public CommonResponse<List<WalletAccountEntity>> getAccountList(@RequestParam(name = "cif", defaultValue = "") String cif) {
        List<WalletAccountEntity> list;
        list = walletAccountDao.getList(Integer.parseInt(cif));

        CommonResponse<List<WalletAccountEntity>> resp = new CommonResponse<>();
        resp.setData(list);
        return resp;
    }

    @DeleteMapping(value=URL_REQUEST_WALLET_ACCOUNT_BY_ID)
    public CommonResponse<WalletAccountEntity> deleteWalletAccountEntity(@PathVariable(name="id") String id) {
        WalletAccountEntity checkAccount = walletAccountDao.getById(Integer.parseInt(id));
        CommonResponse<WalletAccountEntity> resp = new CommonResponse<>();
        if(checkAccount==null) {
            resp.setResponseCode("99");
            resp.setResponseMessage("Not found");
        }else{
            resp.setData(walletAccountRepository.deleteById(Integer.parseInt(id)));
        }
        return resp;
    }
}
