package com.example.museums.service;

import com.example.museums.entities.Exhibit;
import com.example.museums.repository.IExhibitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExhibitService implements IExhibitService{

    private final IExhibitRepository repository;

    @Autowired
    public ExhibitService(IExhibitRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Exhibit exhibit) {
        repository.save(exhibit);
    }
}
