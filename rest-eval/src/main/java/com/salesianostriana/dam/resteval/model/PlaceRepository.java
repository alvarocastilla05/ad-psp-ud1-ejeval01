package com.salesianostriana.dam.resteval.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private HashMap<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
       add(new Place(1L, "Bar Casa Manolo", "Centro", "12.15", "Muy rico", null, "foto.png"));
        add(new Place(2L, "Cerveceria Urbion", "Urbion", "12.15", "Muy rico", null, "foto.png"));
    }

    public Place add(Place place) {
        var id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return List.copyOf(places.values());
    }

    public Optional<Place> edit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k,v) -> {
            v.setName(place.getName());
            v.setDesc(place.getDesc());
            v.setImage(place.getImage());
            v.setCoords(place.getCoords());
            v.setAddress(place.getAddress());
            return v;
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }


}