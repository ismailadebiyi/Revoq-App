package com.rateright.app.repo;

import com.rateright.app.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Reviews, Long> {

    /**
     * @param ratings
     * @return all reviews with a particular ratings
     */
    @Query("SELECT r FROM Reviews r WHERE r.ratings = ?1")
    List<Reviews> findAllByRatings(Integer ratings);

   /* List<Reviews> findAllByCustomerId(Long CustomerId);*/
}
