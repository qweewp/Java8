package com.qweewp.java.stream;

import com.qweewp.java.User;

import java.util.ArrayList;
import java.util.List;

public class Example4 {
    private static final String ADMIN_ROLE = "admin";

    private final List<User> users = new ArrayList<>();

    /**
     * Change:  Remove if statement.
     */
    public boolean hasAdmin() {
        return users.stream()
                .flatMap(user -> user.getRoles().stream())
                .map(role -> role.getName().equals(ADMIN_ROLE))
                .findAny()
                .orElseThrow(NullPointerException::new);
    }

    public List<User> getUsers() {
        return users;
    }
}
