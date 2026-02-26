package org.example.tparchi26022026.exercice2.solid.s.solution;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<String> users = new ArrayList<>();

    public void addUser(String username) {
        users.add(username);
        System.out.println("User added: " + username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public boolean userExists(String username) {
        return users.contains(username);
    }
}
