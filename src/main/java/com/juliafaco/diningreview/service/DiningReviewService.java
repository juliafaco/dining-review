package com.juliafaco.diningreview.service;

import com.juliafaco.diningreview.dto.DiningReviewRequest;
import com.juliafaco.diningreview.dto.DiningReviewResponse;
import com.juliafaco.diningreview.model.DiningReview;
import com.juliafaco.diningreview.model.Restaurant;
import com.juliafaco.diningreview.model.User;
import com.juliafaco.diningreview.repository.DiningReviewRepository;
import com.juliafaco.diningreview.repository.RestaurantRepository;
import com.juliafaco.diningreview.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiningReviewService {
    private final DiningReviewRepository diningReviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    public DiningReviewService(DiningReviewRepository diningReviewRepository,
                               UserRepository userRepository,
                               RestaurantRepository restaurantRepository,
                               RestaurantService restaurantService) {
        this.diningReviewRepository = diningReviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
    }

    public void submitReview(DiningReviewRequest diningReviewRequest) {

        User user = userRepository.findById(diningReviewRequest.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Restaurant restaurant = restaurantRepository.findById(diningReviewRequest.getRestaurantId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));

        DiningReview diningReview = new DiningReview(user,
                restaurant,
                diningReviewRequest.getRating(),
                diningReviewRequest.getCommentary());

        DiningReview savedDiningReview = diningReviewRepository.save(diningReview);

        restaurantService.updateRating(restaurant.getId());


    }

    public List<DiningReviewResponse> getReviewsList(Long restaurantId){
       List<DiningReview> diningReviews = diningReviewRepository.findByRestaurantId(restaurantId);

       List<DiningReviewResponse> responses = new ArrayList<>();

        for(DiningReview diningReview : diningReviews){
            responses.add(new DiningReviewResponse(
                    diningReview.getUser().getUsername(),
                    diningReview.getRating(),
                    diningReview.getCommentary()
            ));
        }

        return responses;
    }

}
