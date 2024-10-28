package com.maya.review_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document

public class Review {

        @Id

        private int reviewId;
        private int bookId; // References the bookId from the Book service
        private String reviewContent;
        private int rating; // Rating out of 5
        private String reviewerName;

}
