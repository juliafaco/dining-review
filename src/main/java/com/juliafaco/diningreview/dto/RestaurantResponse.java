package com.juliafaco.diningreview.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private String description;
    private String zipCode;
    private Double rating;

    public RestaurantResponse(String name, String description, String zipCode, Double rating) {
        this.name = name;
        this.description = description;
        this.zipCode = zipCode;
        this.rating = rating;
    }
}
