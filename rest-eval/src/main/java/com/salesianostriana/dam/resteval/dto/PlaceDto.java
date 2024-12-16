package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

public record PlaceDto (
        String nombre,
        String direccion,
        String localizacion,
        String desc,
        String url
){
    public PlaceDto of(Place place){
        return new PlaceDto(
                place.getName(),
                place.getAddress(),
                place.getCoords(),
                place.getDesc(),
                place.getImage()
        );
    }

}
