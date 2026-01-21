package com.juliafaco.diningreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private Long id;
    private String username;
    private String city;
    private String state;
    private String zipCode;
}
