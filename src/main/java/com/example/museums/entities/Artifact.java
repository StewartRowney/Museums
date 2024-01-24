package com.example.museums.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Artifact {

    @Id
    @GeneratedValue
    @Column(insertable=false, updatable=false)
    private UUID id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id")
    private Exhibit exhibit;

    public Artifact() {

    }
    public Artifact(String name, String description) {
        this.name = name;
        this.description = description;
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
    public Exhibit getExhibit() {
        return exhibit;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }
}
