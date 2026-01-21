package com.juliafaco.diningreview.repository;

import com.juliafaco.diningreview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Boolean existsByName(String name);
    Boolean existsByNameAndZipCode (String name, String zipCode);

    Restaurant findByName(String name);
}
