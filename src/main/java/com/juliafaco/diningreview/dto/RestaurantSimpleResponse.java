package com.juliafaco.diningreview.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RestaurantSimpleResponse {
    private Long id;
    private String name;
    private Double rating;

    public RestaurantSimpleResponse(Long id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
}
