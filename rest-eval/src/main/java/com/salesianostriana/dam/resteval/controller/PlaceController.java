package com.salesianostriana.dam.resteval.controller;

import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.model.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceRepository placeRepository = new PlaceRepository();

    @GetMapping
    public ResponseEntity<Place> getAll(){
        List<Place> result = placeRepository.getAll();

        if (result.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getById(@PathVariable("id") long id){
        Place result = placeRepository.get(id).orElse(null);

        if (result == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody Place place){
        Place result = placeRepository.add(place);

        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> update(@PathVariable("id") long id, @RequestBody Place place){
        Optional<Place> result = placeRepository.get(id);

        if (result.isPresent()) {
            placeRepository.edit(id, place);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Place> delete(@PathVariable("id") long id){
        placeRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}
