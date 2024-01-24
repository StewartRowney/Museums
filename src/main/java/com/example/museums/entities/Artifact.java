package com.example.museums.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Artifact {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private Location locationFound;
    @ManyToOne
    @JoinColumn(name = "id")
    private Exhibit exhibit;

    public Artifact(String name, String description, Location locationFound) {
        this.name = name;
        this.description = description;
        this.locationFound = locationFound;
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
    public Location getLocationFound() {
        return locationFound;
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
    public void setLocationFound(Location locationFound) {
        this.locationFound = locationFound;
    }
    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }
}
