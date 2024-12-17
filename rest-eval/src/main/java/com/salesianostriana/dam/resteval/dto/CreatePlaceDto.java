package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

public record CreatePlaceDto(
        String name,
        String address,
        String coords,
        String image
) {

    public Place toPlace(){
        return  Place.builder()
                .name(this.name)
                .address(this.address)
                .coords(this.coords)
                .image(this.image)
                .build();

    }
}
