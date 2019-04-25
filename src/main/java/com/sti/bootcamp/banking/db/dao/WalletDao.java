package com.sti.bootcamp.banking.db.dao;

import com.sti.bootcamp.banking.db.model.AccountEntity;
import com.sti.bootcamp.banking.db.model.WalletEntity;

import java.util.List;

public interface WalletDao {
    List<WalletEntity> getList(int cif);
    WalletEntity getById(int id);
    WalletEntity save(WalletEntity wallet);
}
