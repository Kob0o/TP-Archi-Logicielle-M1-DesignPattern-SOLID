package org.example.tparchi26022026.exercice2.solid.l.problem;

public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly!");
    }

    @Override
    public void eat() {
        System.out.println("Ostrich is eating plants");
    }
}
