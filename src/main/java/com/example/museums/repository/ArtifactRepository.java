package com.example.museums.repository;

import com.example.museums.entities.Artifact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ArtifactRepository implements IArtifactRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Artifact save(Artifact artifact) {
        entityManager.persist(artifact);
        return artifact;
    }

    @Override
    @Transactional
    public Artifact update(Artifact artifact) {
        entityManager.merge(artifact);
        return  artifact;
    }
    
}
