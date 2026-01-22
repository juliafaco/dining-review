package com.juliafaco.diningreview.controller;

import com.juliafaco.diningreview.dto.DiningReviewResponse;
import com.juliafaco.diningreview.dto.RestaurantRequest;
import com.juliafaco.diningreview.dto.RestaurantResponse;
import com.juliafaco.diningreview.dto.RestaurantSimpleResponse;
import com.juliafaco.diningreview.model.Restaurant;
import com.juliafaco.diningreview.service.DiningReviewService;
import com.juliafaco.diningreview.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final DiningReviewService diningReviewService;

    public RestaurantController(RestaurantService restaurantService, DiningReviewService diningReviewService){
        this.restaurantService = restaurantService;
        this.diningReviewService = diningReviewService;
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

    @GetMapping("/{id}/reviews")
    public List<DiningReviewResponse> getReviewsList(@PathVariable Long id) {
        return diningReviewService.getReviewsList(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
    }
}
