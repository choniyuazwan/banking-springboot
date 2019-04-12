package com.sti.bootcamp.banking.db.dao;

import com.sti.bootcamp.banking.db.model.TransactionEntity;

import java.util.List;

public interface TransactionDao {
    List<TransactionEntity> getList(int cif);

    TransactionEntity getById(int id);

    TransactionEntity save(TransactionEntity transaction);
}
