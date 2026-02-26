package org.example.tparchi26022026.exercice4.reviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;
}
