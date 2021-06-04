package project.musicpolitan.services;

import project.musicpolitan.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review addReview(Review review);

    Review getReviewById(Long id);

    void deleteReview(Review review);

    void deleteReviewById(Long id);

    Review updateReview(Review review);

}
