package com.salesianostriana.dam.resteval.services;

import com.salesianostriana.dam.resteval.error.PlaceNotFoundException;
import com.salesianostriana.dam.resteval.model.Place;
import com.salesianostriana.dam.resteval.model.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;
    private final PlaceRepository placeRepository;

    public List<Place> getAll() {
        List<Place> result = repository.getAll();

        if(result.isEmpty())
            throw new PlaceNotFoundException("No hay restaurantes en la lista");
        return result;
    }

    public Place getById(long id) {
        Optional<Place> result =
                repository.get(id);

        /*if(result.isPresent())
            return result.get();
        else
            throw new PlaceNotFoundException("No hay restaurantes en la lista con id %d".formatted(id));
        */
        return repository.get(id)
                .orElseThrow(() -> new PlaceNotFoundException("No hay restaurante con id %d".formatted(id)));
    }

    public Place create(Place place) {
        return repository.add(place);
    }

    public Place edit(Long id, Place place) {
        return placeRepository.edit(id, place)
                .orElseThrow(() -> new PlaceNotFoundException("No hay restaurante con id %d"));
    }

    public void delete(long id) {
         repository.delete(id);
    }

    /*
    public Place addTagToPlace(Long id, String tag) {
        //Buscar el place
        //Añadir el tag
        //Modificar el place


    }*/
}
