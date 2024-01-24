package com.example.museums;

import com.example.museums.entities.Exhibit;
import com.example.museums.entities.Museum;
import com.example.museums.service.IExhibitService;
import com.example.museums.service.IMuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Populator {

    private final IMuseumService museumService;
    private final IExhibitService exhibitService;
    private final Random rand = new Random();

    @Autowired
    public Populator(IMuseumService museumService, IExhibitService exhibitService) {
        this.museumService = museumService;
        this.exhibitService = exhibitService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void populate(){

        List<Museum> museums = populateMuseum();
        List<Exhibit> exhibits = populateExhibit(museums);
    }

    private List<Museum> populateMuseum() {
        List<Museum> museums = new ArrayList<>();

        String museumsFile = "src/main/resources/data/museums.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(museumsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Museum museum = new Museum(line);
                museumService.save(museum);
                museums.add(museum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return museums;
    }

    private List<Exhibit> populateExhibit(List<Museum> museums) {
        List<Exhibit> exhibits = new ArrayList<>();

        String museumsFile = "src/main/resources/data/exhibits.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(museumsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Museum randomMuseum = museums.get(rand.nextInt(museums.size()));

                Exhibit exhibit = new Exhibit(values[0], values[1], randomMuseum);
                exhibitService.save(exhibit);
                exhibits.add(exhibit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exhibits;
    }
}
