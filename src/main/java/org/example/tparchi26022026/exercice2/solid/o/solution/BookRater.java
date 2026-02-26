package org.example.tparchi26022026.exercice2.solid.o.solution;

import java.util.HashMap;
import java.util.Map;

public class BookRater {
    private final Map<String, RatingStrategy> strategies;

    public BookRater() {
        this.strategies = new HashMap<>();
        strategies.put("fiction", new FictionRatingStrategy());
        strategies.put("science", new ScienceRatingStrategy());
        strategies.put("history", new HistoryRatingStrategy());
    }

    public double calculateRating(String bookType, int reviewCount) {
        RatingStrategy strategy = strategies.get(bookType);
        if (strategy == null) {
            return 0;
        }
        return strategy.calculateRating(reviewCount);
    }

    public void addRatingStrategy(String bookType, RatingStrategy strategy) {
        strategies.put(bookType, strategy);
    }
}
