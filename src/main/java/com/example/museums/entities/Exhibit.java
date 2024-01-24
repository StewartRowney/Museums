package com.example.museums.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Exhibit {

    @Id
    @GeneratedValue
    @Column(insertable=false, updatable=false)
    private UUID id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id")
    private Museum museum;
    @OneToMany(mappedBy = "exhibit", cascade = CascadeType.ALL)
    List<Artifact> artifacts;

    public Exhibit() {

    }
    public Exhibit(String name, String description, Museum museum) {
        this.name = name;
        this.description = description;
        this.museum = museum;
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
    public Museum getMuseum() {
        return museum;
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
    public void setMuseum(Museum museum) {
        this.museum = museum;
    }
    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }
}
