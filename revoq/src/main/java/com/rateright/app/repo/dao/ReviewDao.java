package com.rateright.app.repo.dao;

import com.rateright.app.model.Reviews;

import java.util.List;

public interface ReviewDao {
    void addReview (Reviews reviews);
    List<Reviews> listAllReviews();
    List<Reviews> listAllReviewsByRatings(Integer ratings);
    /*List<Reviews> listAllReviewsByCustomerId(Long customerId);*/

}
