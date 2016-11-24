package com.qweewp.java.stream;

import com.qweewp.java.Role;
import com.qweewp.java.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Example4 {
    private static final String ADMIN_ROLE = "admin";

    private final List<User> users = new ArrayList<>();

    /**
     * Change:  Remove if statement.
     */
    public boolean hasAdmin() {
        return users.stream()
                .map(Objects::requireNonNull)
                .flatMap(user -> user.getRoles().stream())
                .map(Role::getName)
                .anyMatch(ADMIN_ROLE::equals);
    }

    public List<User> getUsers() {
        return users;
    }
}
