package com.rateright.app.repo.dataAccessServices;

import com.rateright.app.model.Reviews;
import com.rateright.app.repo.ReviewRepo;
import com.rateright.app.repo.dao.ReviewDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reviewJpa")
public class ReviewJPADataAccessServices implements ReviewDao {

    private final ReviewRepo reviewRepo;

    public ReviewJPADataAccessServices(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void addReview(Reviews reviews) {
        reviewRepo.save(reviews);
    }

    @Override
    public List<Reviews> listAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public List<Reviews> listAllReviewsByRatings(Integer ratings) {
        return reviewRepo.findAllByRatings(ratings);
    }

    @Override
    public List<Reviews> listAllReviewsByCustomerId(Long customerId) {
        return reviewRepo.findAllByCustomerId(customerId);
    }
}
