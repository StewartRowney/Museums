package com.example.museums.service;

import com.example.museums.entities.Museum;
import com.example.museums.repository.IMuseumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuseumService implements IMuseumService{

    private IMuseumRepository repository;

    @Autowired
    public MuseumService(IMuseumRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Museum museum) {
        repository.save(museum);
    }
}
