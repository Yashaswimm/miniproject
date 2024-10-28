package com.maya.review_service.controller;

import com.maya.review_service.service.ReviewService;
import com.maya.review_service.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviewsrv")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Get all reviews for a specific book by bookId
    @GetMapping("/reviews/book/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable int bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    // Add a new review
    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // Delete a review
    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable int reviewId) {
        reviewService.deleteReview(reviewId);
        String res="Successfully deleted";
        return res;

    }
}
