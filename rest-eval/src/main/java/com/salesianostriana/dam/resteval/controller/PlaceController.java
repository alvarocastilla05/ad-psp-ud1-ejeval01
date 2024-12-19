package com.salesianostriana.dam.resteval.controller;

import com.salesianostriana.dam.resteval.dto.CreatePlaceDto;
import com.salesianostriana.dam.resteval.dto.GetPlaceDto;
import com.salesianostriana.dam.resteval.dto.ListGetPlaceDto;
import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.model.PlaceRepository;
import com.salesianostriana.dam.resteval.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place/")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ListGetPlaceDto getAll(){
        return ListGetPlaceDto.of(
                placeService.getAll()
        );
    }

    @GetMapping("{id}")
    public Place getById(@PathVariable("id") long id){
        return placeService.getById(id);
    }



    @PostMapping
    public ResponseEntity<Place> create(@RequestBody CreatePlaceDto dto){
       return ResponseEntity.status(201)
               .body(
                       placeService.create(dto.toPlace())
               );
    }


    @PutMapping("{id}")
    public Place edit(@PathVariable Long id, @RequestBody CreatePlaceDto dto){
        return placeService.edit(id, dto.toPlace());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        placeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*@PutMapping("{id}/tag/add/{tag}")
    public Place addTag(@PathVariable("id") long id, @PathVariable("tag") String tag){

    }*/


}
