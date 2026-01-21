package com.juliafaco.diningreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RestaurantRequest {
    private String name;
    private String description;
    private String zipCode;
}
