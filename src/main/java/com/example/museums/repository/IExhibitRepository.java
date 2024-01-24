package com.example.museums.repository;

import com.example.museums.entities.Exhibit;
import jakarta.transaction.Transactional;

public interface IExhibitRepository {
    @Transactional
    Exhibit save(Exhibit exhibit);

    @Transactional
    Exhibit update(Exhibit exhibit);
}
