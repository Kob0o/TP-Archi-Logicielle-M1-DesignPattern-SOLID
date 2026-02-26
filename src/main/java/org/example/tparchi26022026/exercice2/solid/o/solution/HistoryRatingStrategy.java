package org.example.tparchi26022026.exercice2.solid.o.solution;

public class HistoryRatingStrategy implements RatingStrategy {
    @Override
    public double calculateRating(int reviewCount) {
        return Math.min(5, reviewCount * 0.08 + 3.0);
    }
}
