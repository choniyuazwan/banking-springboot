package com.sti.bootcamp.banking.db.model;

import javax.persistence.*;

@Entity(name = "Transaction")
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "type")
    private TransactionTypeEntity transactionType;

    @ManyToOne
    @JoinColumn(name = "account_debit")
    private AccountEntity accountDebit;

    @ManyToOne
    @JoinColumn(name = "account_credit")
    private AccountEntity accountCredit;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "cif")
    private CustomerEntity customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionTypeEntity getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEntity transactionType) {
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public AccountEntity getAccountDebit() {
        return accountDebit;
    }

    public void setAccountDebit(AccountEntity accountDebit) {
        this.accountDebit = accountDebit;
    }

    public AccountEntity getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(AccountEntity accountCredit) {
        this.accountCredit = accountCredit;
    }
}
