package com.sti.bootcamp.banking.db.repository;

import com.sti.bootcamp.banking.db.model.WalletEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<WalletEntity, Integer> {
    WalletEntity deleteById(int id);
}