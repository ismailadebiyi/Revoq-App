package com.rateright.app.controllers;

import com.rateright.app.requests.ReviewPostRequest;
import com.rateright.app.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    //TODO: ListAllReviews, ListAllReviewsByRatings, ListAllReviewsByCustomerId, RaiseIssueTicketForRatingsLessThan4,
    @PostMapping
    public void postReview(@RequestBody ReviewPostRequest reviewPostRequest){
        log.info("New Review Posted {}", reviewPostRequest);
        reviewService.postReview(reviewPostRequest);
    }
}
