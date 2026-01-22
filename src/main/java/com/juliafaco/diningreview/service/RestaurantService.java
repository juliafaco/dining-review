package com.juliafaco.diningreview.service;

import com.juliafaco.diningreview.dto.DiningReviewResponse;
import com.juliafaco.diningreview.dto.RestaurantRequest;
import com.juliafaco.diningreview.dto.RestaurantResponse;
import com.juliafaco.diningreview.dto.RestaurantSimpleResponse;
import com.juliafaco.diningreview.model.DiningReview;
import com.juliafaco.diningreview.model.Restaurant;
import com.juliafaco.diningreview.repository.DiningReviewRepository;
import com.juliafaco.diningreview.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final DiningReviewRepository diningReviewRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, DiningReviewRepository diningReviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.diningReviewRepository = diningReviewRepository;
    }

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {
        if (restaurantRepository.existsByNameAndZipCode(restaurantRequest.getName(), restaurantRequest.getZipCode())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Restaurant name already exists in this ZIP code");
        }
        Restaurant restaurant = new Restaurant(restaurantRequest.getName(),
                restaurantRequest.getDescription(),
                restaurantRequest.getZipCode(), 5.0 );

        restaurantRepository.save(restaurant);

        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getZipCode(),
                restaurant.getRating());
    }

    public List<RestaurantSimpleResponse> getAllRestaurants() {
        List<RestaurantSimpleResponse> restaurantSimpleResponses = new ArrayList<>();

        for (Restaurant restaurant : restaurantRepository.findAll()) {
            restaurantSimpleResponses.add(new RestaurantSimpleResponse(
                    restaurant.getId(),
                    restaurant.getName(),
                    restaurant.getRating()));
        }
        return restaurantSimpleResponses;
    }

    public RestaurantResponse getRestaurantById(Long id){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));

        return new RestaurantResponse(restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getZipCode(),
                restaurant.getRating());
    }

    public void updateRating(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found."));
        List<DiningReview> diningReviews = diningReviewRepository.findByRestaurantId(restaurantId);

        Double ratings = 0.00;
        for(DiningReview diningReview : diningReviews){
            ratings = ratings + diningReview.getRating();
        }
        restaurant.setRating(ratings/(diningReviews.size()));
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long restaurantId){
        if(!restaurantRepository.existsById(restaurantId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found");
        }
        restaurantRepository.deleteById(restaurantId);
    }
}
