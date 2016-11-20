package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Example2 {
    private final Set<User> users = new HashSet<>();

    public boolean checkPermission(Permission permission) {
        AtomicBoolean found = new AtomicBoolean();
        users.forEach(
                u -> u.getRoles().forEach(
                        r -> {
                            if (r.getPermissions().contains(permission)) {
                                found.set(true);
                            }
                        }
                )
        );
        return found.get();
    }
}
