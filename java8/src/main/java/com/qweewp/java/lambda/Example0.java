package com.qweewp.java.lambda;

import com.qweewp.java.Permission;
import com.qweewp.java.User;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Example0 {
    private final Set<User> users = new HashSet<>();

    public Set<User> findEditors() {
        return users.stream()
                .filter(u -> u.getRoles().stream()
                        .anyMatch(r -> r.getPermissions().contains(Permission.EDIT)))
                .collect(toSet());
    }
}
