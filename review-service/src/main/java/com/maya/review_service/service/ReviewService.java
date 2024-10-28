package com.maya.review_service.service;

import com.maya.review_service.client.BookClient;
import com.maya.review_service.dao.ReviewRepository;
import com.maya.review_service.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookClient bookClient;

    public List<Review> getReviewsByBookId(int bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Review saveReview(Review review) {
        // Call Book Service using Feign Client to verify the book
        Book book = bookClient.getBookById(review.getBookId());
        if (book != null) {
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Book not found for id: " + review.getBookId());
        }
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}