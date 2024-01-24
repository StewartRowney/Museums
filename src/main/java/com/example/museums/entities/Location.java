package com.example.museums.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class Location {

    private UUID id;
    private String latitude;
    private String longitude;
}
