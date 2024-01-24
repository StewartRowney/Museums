package com.example.museums.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Exhibit {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "exhibit", cascade = CascadeType.ALL)
    List<Artifact> artifacts;

    public Exhibit(String name, String description) {
        this.name = name;
        this.description = description;
        this.artifacts = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }
}
