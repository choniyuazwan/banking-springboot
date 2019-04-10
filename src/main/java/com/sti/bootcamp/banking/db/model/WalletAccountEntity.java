package com.sti.bootcamp.banking.db.model;

import javax.persistence.*;

@Entity(name = "WalletAccount")
@Table(name = "wallet_account")
public class WalletAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private WalletEntity wallet;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private AccountEntity account;

    @ManyToOne
    @JoinColumn(name = "cif")
    private CustomerEntity customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WalletEntity getWallet() {
        return wallet;
    }

    public void setWallet(WalletEntity wallet) {
        this.wallet = wallet;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
