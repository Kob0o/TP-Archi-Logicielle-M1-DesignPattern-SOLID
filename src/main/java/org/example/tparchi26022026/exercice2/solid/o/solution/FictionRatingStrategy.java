package org.example.tparchi26022026.exercice2.solid.o.solution;

public class FictionRatingStrategy implements RatingStrategy {
    @Override
    public double calculateRating(int reviewCount) {
        return Math.min(5, reviewCount * 0.1 + 2.0);
    }
}
