package org.example.tparchi26022026.exercice2.solid.d.solution;

public class FileRepository implements DataRepository {
    @Override
    public void save(String key, String value) {
        System.out.println("Saving to File: " + key + " = " + value);
    }
}
