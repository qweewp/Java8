package com.qweewp.java.stream;

import com.qweewp.java.Role;
import com.qweewp.java.User;

import java.util.ArrayList;
import java.util.List;

public class Example4 {
    private static final String ADMIN_ROLE = "admin";

    private final List<User> users = new ArrayList<>();

    public boolean hasAdmin() {
        return users.stream()
                .map(u -> {
                    if (u == null) {
                        throw new NullPointerException();
                    }
                    return u;
                })
                .flatMap(u -> u.getRoles().stream())
                .map(Role::getName)
                .anyMatch(name -> ADMIN_ROLE.equals(name));
    }

    public List<User> getUsers() {
        return users;
    }
}
