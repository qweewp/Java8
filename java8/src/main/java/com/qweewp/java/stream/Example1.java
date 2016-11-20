package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Example1 {
    private final Set<User> users = new HashSet<>();

    public Map<String, Set<User>> findEditors() {
        Map<String, Set<User>> editors = new HashMap<>();
        users.forEach(u -> u.getRoles().stream()
                .filter(r -> r.getPermissions().contains(Permission.EDIT))
                .forEach(r -> {
                    Set<User> usersInRole = editors.get(r.getName());
                    if (usersInRole == null) {
                        usersInRole = new HashSet<>();
                        editors.put(r.getName(), usersInRole);
                    }
                    usersInRole.add(u);
                })
        );
        return editors;
    }
}
