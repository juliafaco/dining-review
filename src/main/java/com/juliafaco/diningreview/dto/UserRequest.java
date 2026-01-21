package com.juliafaco.diningreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserRequest {
    private String username;
    private String city;
    private String state;
    private String zipCode;
}
