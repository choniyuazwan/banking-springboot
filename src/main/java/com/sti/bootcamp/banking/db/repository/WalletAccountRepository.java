package com.sti.bootcamp.banking.db.repository;

import com.sti.bootcamp.banking.db.model.WalletAccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletAccountRepository extends CrudRepository<WalletAccountEntity, Integer> {
    WalletAccountEntity deleteById(int id);
}
