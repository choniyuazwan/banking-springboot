package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.TransactionDao;
import com.sti.bootcamp.banking.db.model.TransactionEntity;
import com.sti.bootcamp.banking.exception.CustomException;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    public static final String URL_REQUEST_TRANSACTION = "/transaction";
    public static final String URL_REQUEST_TRANSACTION_LIST = "/transactions";
    public static final String URL_REQUEST_TRANSACTION_BY_ID = "/transaction/{id}";

    @Autowired
    private TransactionDao transactionDao;

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
    public CommonResponse<TransactionEntity> createTransactionEntity(@RequestBody TransactionEntity transaction) {
        CommonResponse<TransactionEntity> response = new CommonResponse<>();
        response.setData(transactionDao.save(transaction));
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
