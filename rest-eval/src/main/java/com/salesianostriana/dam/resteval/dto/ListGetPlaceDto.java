package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.model.Place;

import java.util.List;

public record ListGetPlaceDto (
        long count,
        List<GetPlaceDto> items
){

    public static ListGetPlaceDto of(List<Place> list) {
        return new ListGetPlaceDto(
                list.size(),
                list.stream()
                        .map(GetPlaceDto::of)
                        .toList()

        );
    }
}
