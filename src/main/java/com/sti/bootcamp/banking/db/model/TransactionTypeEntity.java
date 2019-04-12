package com.sti.bootcamp.banking.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TransactionType")
@Table(name = "transaction_type")
public class TransactionTypeEntity {
    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "description")
    private String description;
    @Column(name = "account_type")
    private String accountType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
