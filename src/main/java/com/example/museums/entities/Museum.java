package com.example.museums.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Museum {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "museum", cascade = CascadeType.ALL)
    List<Exhibit> exhibits;

    public Museum() {
    }
    public Museum(String name) {
        this.name = name;
        this.exhibits = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Exhibit> getExhibits() {
        return exhibits;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExhibits(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }
}
