package com.juliafaco.diningreview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_name")
    private String name;

    @Column
    private String description;

    @Column
    private String zipCode;

    @Column
    private Double rating;

    public Restaurant(Long id, String name, String description, String zipCode, Double rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.zipCode = zipCode;
        this.rating = rating;
    }

    public Restaurant(String name, String description, String zipCode, Double rating) {
        this.name = name;
        this.description = description;
        this.zipCode = zipCode;
        this.rating = rating;
    }


}
