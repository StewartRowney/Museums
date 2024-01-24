package com.example.museums.repository;


import com.example.museums.entities.Exhibit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ExhibitRepository implements IExhibitRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Exhibit save(Exhibit exhibit) {
        entityManager.persist(exhibit);
        return exhibit;
    }

    @Override
    @Transactional
    public Exhibit update(Exhibit exhibit) {
        entityManager.merge(exhibit);
        return  exhibit;
    }

}
