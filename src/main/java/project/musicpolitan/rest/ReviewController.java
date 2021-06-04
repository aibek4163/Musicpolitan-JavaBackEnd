package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Review;
import project.musicpolitan.services.ReviewService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/review")
    public ResponseEntity<?> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        for (Review r : reviews) {
            r.getUsers().getAuthorities().clear();
        }
        return ResponseEntity.ok(reviews);
    }

    @PostMapping(value = "/review")
    public ResponseEntity<?> addReview(@RequestBody Review reviews) {
        Review r = reviewService.addReview(reviews);
        return ResponseEntity.ok(r);
    }

    @GetMapping(value = "/review/{review_id}")
    public ResponseEntity<?> getReview(@PathVariable(name = "review_id") Long id) {
        Review reviews = reviewService.getReviewById(id);
        return ResponseEntity.ok(reviews);
    }

    @PutMapping(value = "/review")
    public ResponseEntity<?> editReview(@RequestBody Review reviews) {
        reviewService.updateReview(reviews);
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping(value = "/review")
    public ResponseEntity<?> deleteReview(@RequestBody Review reviews) {
        reviewService.deleteReview(reviews);
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping(value = "/review/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable(name = "id") Long id) {
        Review reviews = reviewService.getReviewById(id);
        reviewService.deleteReview(reviews);
        return ResponseEntity.ok(reviews);
    }
}
