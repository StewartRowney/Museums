package com.example.museums.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Museum {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Location location;
    @OneToMany(mappedBy = "museum", cascade = CascadeType.ALL)
    List<Exhibit> exhibits;

    public Museum(String name, Location location) {
        this.name = name;
        this.location = location;
        this.exhibits = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Location getLocation() {
        return location;
    }
    public List<Exhibit> getExhibits() {
        return exhibits;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setExhibits(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }
}
