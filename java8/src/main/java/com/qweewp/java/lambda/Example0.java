package com.qweewp.java.lambda;

import com.qweewp.java.User;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Example0 {
    private final Set<User> users = new HashSet<>();

    /**
     * Change:  add {@link Example0#getUsers()} for access to private final list
     *          create {@link User#hasEditPermission()} method, to make filter predicate smaller.
     */
    public Set<User> findEditors() {
        return users.stream()
                .filter(User::hasEditPermission)
                .collect(toSet());
    }

    public Set<User> getUsers() {
        return users;
    }
}
