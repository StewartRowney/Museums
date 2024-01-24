package com.example.museums.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Exhibit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id",insertable=false, updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "museum_id")
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

}
