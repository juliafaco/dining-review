package com.juliafaco.diningreview.controller;

import com.juliafaco.diningreview.dto.DiningReviewRequest;
import com.juliafaco.diningreview.dto.DiningReviewResponse;
import com.juliafaco.diningreview.service.DiningReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dining-reviews")
public class DiningReviewController {
    public final DiningReviewService diningReviewService;

    public DiningReviewController(DiningReviewService diningReviewService){
        this.diningReviewService = diningReviewService;
    }

    @PostMapping
    public void submitReview(@RequestBody DiningReviewRequest diningReviewRequest) {
        diningReviewService.submitReview(diningReviewRequest);
    }
}
