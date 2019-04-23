package com.sti.bootcamp.banking.db.dao.impl;

import com.sti.bootcamp.banking.db.dao.AccountDao;
import com.sti.bootcamp.banking.db.model.AccountEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AccountEntity> getList(int cif) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AccountEntity> query = builder.createQuery(AccountEntity.class);
        Root<AccountEntity> root = query.from(AccountEntity.class);

        query.select(root).where(builder.equal(root.get("customer").get("cif"), cif));

        Query q = em.createQuery(query);

        return q.getResultList();
    }

    @Override
    public AccountEntity getById(int id) {
        return em.find(AccountEntity.class, id);
    }

    @Override
    @Transactional
    public AccountEntity save(AccountEntity account) {
        AccountEntity saveAccount = em.merge(account);
        return saveAccount;
    }
}
