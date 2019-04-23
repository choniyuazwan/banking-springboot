package com.sti.bootcamp.banking.db.dao.impl;

import com.sti.bootcamp.banking.db.dao.WalletDao;
import com.sti.bootcamp.banking.db.model.WalletEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WalletDaoImpl implements WalletDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<WalletEntity> getList(int cif) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<WalletEntity> query = builder.createQuery(WalletEntity.class);
        Root<WalletEntity> root = query.from(WalletEntity.class);

        query.select(root).where(builder.equal(root.get("customer").get("cif"), cif));

        Query q = em.createQuery(query);

        return q.getResultList();
    }

    @Override
    public WalletEntity getById(int id) {
        return em.find(WalletEntity.class, id);
    }

    @Override
    @Transactional
    public WalletEntity save(WalletEntity wallet) {
        WalletEntity saveWallet = em.merge(wallet);
        return saveWallet;
    }
}
