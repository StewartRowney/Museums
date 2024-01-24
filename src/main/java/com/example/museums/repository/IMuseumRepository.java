package com.example.museums.repository;

import com.example.museums.entities.Museum;

public interface IMuseumRepository {
    Museum save(Museum museum);

    Museum update(Museum museum);
}
