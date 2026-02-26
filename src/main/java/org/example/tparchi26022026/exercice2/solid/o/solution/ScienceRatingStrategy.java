package org.example.tparchi26022026.exercice2.solid.o.solution;

public class ScienceRatingStrategy implements RatingStrategy {
    @Override
    public double calculateRating(int reviewCount) {
        return Math.min(5, reviewCount * 0.15 + 2.5);
    }
}
