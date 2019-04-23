package com.sti.bootcamp.banking.db.dao.impl;

import com.sti.bootcamp.banking.db.dao.TransactionDao;
import com.sti.bootcamp.banking.db.model.TransactionEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TransactionEntity> getList(int cif) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TransactionEntity> query = builder.createQuery(TransactionEntity.class);
        Root<TransactionEntity> root = query.from(TransactionEntity.class);

        query.select(root).where(builder.equal(root.get("customer").get("cif"), cif));

        Query q = em.createQuery(query);

        return q.getResultList();
    }

    @Override
    public TransactionEntity getById(int id) {
        return em.find(TransactionEntity.class, id);
    }

    @Override
    @Transactional
    public TransactionEntity save(TransactionEntity transaction) {
        TransactionEntity saveTransaction = em.merge(transaction);
        return saveTransaction;
    }
}
