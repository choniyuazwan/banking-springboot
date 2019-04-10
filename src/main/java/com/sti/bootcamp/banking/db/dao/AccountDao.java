package com.sti.bootcamp.banking.db.dao;

import com.sti.bootcamp.banking.db.model.AccountEntity;

import java.util.List;

public interface AccountDao {
    List<AccountEntity> getList();
    AccountEntity getById(int id);
    AccountEntity save(AccountEntity account);
}
