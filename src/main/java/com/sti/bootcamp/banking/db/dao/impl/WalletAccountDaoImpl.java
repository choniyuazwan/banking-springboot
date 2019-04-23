package com.sti.bootcamp.banking.db.dao.impl;

import com.sti.bootcamp.banking.db.dao.WalletAccountDao;
import com.sti.bootcamp.banking.db.model.WalletAccountEntity;
import com.sti.bootcamp.banking.db.model.WalletAccountEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WalletAccountDaoImpl implements WalletAccountDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<WalletAccountEntity> getList(int cif) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<WalletAccountEntity> query = builder.createQuery(WalletAccountEntity.class);
        Root<WalletAccountEntity> root = query.from(WalletAccountEntity.class);

        query.select(root).where(builder.equal(root.get("customer").get("cif"), cif));

        Query q = em.createQuery(query);

        return q.getResultList();
    }

    @Override
    public WalletAccountEntity getById(int id) {
        return em.find(WalletAccountEntity.class, id);
    }

    @Override
    @Transactional
    public WalletAccountEntity save(WalletAccountEntity walletAccount) {
        WalletAccountEntity saveWalletAccount = em.merge(walletAccount);
        return saveWalletAccount;
    }

    @Override
    public WalletAccountEntity delete(WalletAccountEntity walletAccount) {
        em.remove(walletAccount);
        return walletAccount;
    }
}
