package com.sti.bootcamp.banking.db.repository;

import com.sti.bootcamp.banking.db.model.AccountEntity;
import com.sti.bootcamp.banking.db.model.WalletAccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    AccountEntity deleteById(int id);
}
