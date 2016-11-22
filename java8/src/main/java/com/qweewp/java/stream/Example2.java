package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.Role;
import com.qweewp.java.User;

import java.util.HashSet;
import java.util.Set;

public class Example2 {
    private final Set<User> users = new HashSet<>();

    /**
     * Change:  Make the code more readable by removing ForEach calls.
     */
    public boolean checkPermission(Permission permission) {
        return users.stream().
                flatMap(user -> user.getRoles().stream()).
                map(Role::getPermissions).
                anyMatch(permissions -> permissions.contains(permission));
    }

    public Set<User> getUsers() {
        return users;
    }
}
