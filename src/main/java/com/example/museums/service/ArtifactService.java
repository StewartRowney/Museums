package com.example.museums.service;

import com.example.museums.entities.Artifact;
import com.example.museums.repository.IArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactService implements IArtifactService{

    private final IArtifactRepository repository;

    @Autowired
    public ArtifactService(IArtifactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Artifact artifact) {
        repository.save(artifact);
    }
}
