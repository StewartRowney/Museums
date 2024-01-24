package com.example.museums.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
public class Artifact {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id",insertable=false, updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "exhibit_id")
    private Exhibit exhibit;

    public Artifact() {
    }
    public Artifact(String name, String description, Exhibit exhibit) {
        this.name = name;
        this.description = description;
        this.exhibit = exhibit;
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
