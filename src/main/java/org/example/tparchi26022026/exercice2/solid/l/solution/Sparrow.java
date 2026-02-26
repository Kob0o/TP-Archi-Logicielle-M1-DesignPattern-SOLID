package org.example.tparchi26022026.exercice2.solid.l.solution;

public class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow is eating seeds");
    }
}
