package com.example.museums.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Location {

    @Id
    @GeneratedValue
    UUID id;
    String latitude;
    String longitude;
}
