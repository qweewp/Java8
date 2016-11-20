package com.qweewp.java.optional;

import com.qweewp.java.User;

import java.util.Optional;

public class Example5 {
    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(5L, "Mikalai"));
    }

    public String getUserName(Long userId) {
        Optional<User> user = findById(userId);
        if (user.isPresent()) {
            return user.get().getName();
        }
        throw new IllegalStateException("User not found");
    }
}
