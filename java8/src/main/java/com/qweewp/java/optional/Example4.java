package com.qweewp.java.optional;

import com.qweewp.java.User;

import java.util.List;
import java.util.Optional;

public class Example4 {
    private static final String ADMIN_ROLE = "admin";

    public User findAnyAdmin() {
        Optional<List<User>> users = findUsersByRole(ADMIN_ROLE);
        if (users.isPresent() && !users.get().isEmpty()) {
            return users.get().get(0);
        }
        throw new IllegalStateException("No admins found");
    }

    private Optional<List<User>> findUsersByRole(String role) {
        //real search in DB
        return Optional.empty();
    }
}
