package com.example.museums;

import com.example.museums.entities.Museum;
import com.example.museums.service.IMuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Populator {

    private final IMuseumService museumService;

    @Autowired
    public Populator(IMuseumService museumService) {
        this.museumService = museumService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void populate(){

        List<Museum> museums = new ArrayList<>();

        Museum museum1 = new Museum("Quantum Artefacts Gallery");
        museums.add(museum1);

        Museum museum2 = new Museum("TechnoTime Museum of Innovation");
        museums.add(museum2);

        Museum museum3 = new Museum("Ethereal Wonders Exhibition Center");
        museums.add(museum3);

        Museum museum4 = new Museum("RoboArt Archives");
        museums.add(museum4);

        Museum museum5 = new Museum("Abstract Alchemy Museum");
        museums.add(museum5);

        for (Museum museum: museums) {
            museumService.save(museum);
        }

    }
}
