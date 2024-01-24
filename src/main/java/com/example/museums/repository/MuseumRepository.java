package com.example.museums.repository;
import com.example.museums.entities.Museum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MuseumRepository implements IMuseumRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Museum save(Museum museum) {
        entityManager.persist(museum);
        return museum;
    }

    @Override
    @Transactional
    public Museum update(Museum museum) {
        entityManager.merge(museum);
        return  museum;
    }

}
