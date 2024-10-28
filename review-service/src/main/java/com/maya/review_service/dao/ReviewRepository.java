package com.maya.review_service.dao;

import com.maya.review_service.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface ReviewRepository extends MongoRepository<Review,Integer> {
    List<Review> findByBookId(int bookId);
}
