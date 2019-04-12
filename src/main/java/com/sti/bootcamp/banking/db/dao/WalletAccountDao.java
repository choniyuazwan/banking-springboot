package com.sti.bootcamp.banking.db.dao;

import com.sti.bootcamp.banking.db.model.WalletAccountEntity;

import java.util.List;

public interface WalletAccountDao {
    List<WalletAccountEntity> getList(int cif);

    WalletAccountEntity getById(int id);

    WalletAccountEntity save(WalletAccountEntity walletAccount);
    WalletAccountEntity delete(WalletAccountEntity walletAccount);
}
