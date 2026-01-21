package com.juliafaco.diningreview.controller;

import com.juliafaco.diningreview.dto.RestaurantRequest;
import com.juliafaco.diningreview.dto.RestaurantResponse;
import com.juliafaco.diningreview.dto.RestaurantSimpleResponse;
import com.juliafaco.diningreview.model.Restaurant;
import com.juliafaco.diningreview.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public RestaurantResponse createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.createRestaurant(restaurantRequest);
    }

    @GetMapping
    public List<RestaurantSimpleResponse> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public RestaurantResponse getRestaurantById(@PathVariable Long id){
       return restaurantService.getRestaurantById(id);
    }
}
