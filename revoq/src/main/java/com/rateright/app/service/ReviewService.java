package com.rateright.app.service;

import com.rateright.app.model.Reviews;
import com.rateright.app.repo.dao.ReviewDao;
import com.rateright.app.requests.ReviewPostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewDao reviewDao;


    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public void postReview(ReviewPostRequest reviewPostRequest){
        Reviews reviews = Reviews.builder()
                .customerId(reviewPostRequest.customerId())
                .ratings(reviewPostRequest.ratings())
                .comment(reviewPostRequest.comment())
                .build();
        reviewDao.addReview(reviews);
    }

    public List<Reviews> showAllReviews(){
        return reviewDao.listAllReviews();
    }

    public List<Reviews> showAllReviewsByRatings(Integer ratings){
        return reviewDao.listAllReviewsByRatings(ratings);
    }

    public List<Reviews> showAllReviewsByCustmerId(Long customerId){
        return reviewDao.listAllReviewsByCustomerId(customerId);
    }
}
