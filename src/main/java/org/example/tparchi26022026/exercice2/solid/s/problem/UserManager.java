package org.example.tparchi26022026.exercice2.solid.s.problem;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<String> users = new ArrayList<>();

    public void addUser(String username) {
        if (isValidUsername(username)) {
            users.add(username);
            System.out.println("User added: " + username);
        }
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public void notifyUser(String username, String message) {
        System.out.println("Email sent to " + username + ": " + message);
    }

    public void saveUserToDatabase(String username) {
        System.out.println("Saving " + username + " to database");
    }
}
