package com.juliafaco.diningreview.repository;

import com.juliafaco.diningreview.dto.RestaurantResponse;
import com.juliafaco.diningreview.model.DiningReview;
import com.juliafaco.diningreview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {
    List<DiningReview> findByRestaurantId(Long restaurantId);
}
