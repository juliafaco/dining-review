package com.juliafaco.diningreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DiningReviewRequest {
    private Long userId;
    private Long restaurantId;
    private Double rating;
    private String commentary;
}
