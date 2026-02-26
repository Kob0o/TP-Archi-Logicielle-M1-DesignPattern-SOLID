package org.example.tparchi26022026.exercice2.solid.s.solution;

public class UserValidator {
    public boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }
}
