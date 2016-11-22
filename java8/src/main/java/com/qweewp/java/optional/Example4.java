package com.qweewp.java.optional;

import com.qweewp.java.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Example4 {
    private static final String ADMIN_ROLE = "admin";

    /**
     * Change: Remove if statement.
     */
    public User findAnyAdmin() {
        Optional<List<User>> users = findUsersByRole(ADMIN_ROLE);
        return users.
                orElseThrow(getIllegalStateExceptionSupplier())
                .stream()
                .findAny()
                .orElseThrow(getIllegalStateExceptionSupplier());
    }

    private Optional<List<User>> findUsersByRole(String role) {
        //real search in DB
        return Optional.empty();
    }

    private Supplier<IllegalStateException> getIllegalStateExceptionSupplier() {
        return () -> new IllegalStateException("No admins found");
    }
}
