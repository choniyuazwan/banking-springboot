package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.WalletDao;
import com.sti.bootcamp.banking.db.model.WalletEntity;
import com.sti.bootcamp.banking.exception.CustomException;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    public static final String URL_REQUEST_WALLET = "/wallet";
    public static final String URL_REQUEST_WALLET_LIST = "/wallets";
    public static final String URL_REQUEST_WALLET_BY_ID = "/wallet/{id}";

    @Autowired
    private WalletDao walletDao;

    @GetMapping(value = URL_REQUEST_WALLET_BY_ID)
    public CommonResponse<WalletEntity> getWalletEntity(@PathVariable(name = "id") String id) throws CustomException {
        WalletEntity wallet = walletDao.getById(Integer.parseInt(id));
        CommonResponse<WalletEntity> response = new CommonResponse<>();
        if (wallet == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(wallet);
        }
        return response;
    }

    @PostMapping(value = URL_REQUEST_WALLET)
    public CommonResponse<WalletEntity> createWalletEntity(@RequestBody WalletEntity wallet) {
        CommonResponse<WalletEntity> response = new CommonResponse<>();
        response.setData(walletDao.save(wallet));
        return response;
    }

    @PutMapping(value = URL_REQUEST_WALLET)
    public CommonResponse<WalletEntity> updateWalletEntity(@RequestBody WalletEntity wallet) throws CustomException {
        WalletEntity checkAccount = walletDao.getById(wallet.getId());
        CommonResponse<WalletEntity> response = new CommonResponse<>();
        if (checkAccount == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(walletDao.save(checkAccount));
        }
        return response;
    }

    @GetMapping(value = URL_REQUEST_WALLET_LIST)
    public CommonResponse<List<WalletEntity>> getAccountList(@RequestParam(name = "cif", defaultValue = "") String cif) {
        List<WalletEntity> list;
        list = walletDao.getList(Integer.parseInt(cif));

        CommonResponse<List<WalletEntity>> resp = new CommonResponse<>();
        resp.setData(list);
        return resp;
    }
}
