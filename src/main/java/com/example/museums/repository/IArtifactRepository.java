package com.example.museums.repository;

import com.example.museums.entities.Artifact;
import jakarta.transaction.Transactional;

public interface IArtifactRepository {
    @Transactional
    Artifact save(Artifact artifact);

    @Transactional
    Artifact update(Artifact artifact);
}
