package com.qweewp.java.optional;

import com.qweewp.java.User;

import java.util.Optional;
import java.util.function.Supplier;

public class Example5 {
    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(5L, "Oleh"));
    }

    /**
     * Change:  Replace if statement with {@link Optional#orElseThrow(Supplier)} that make the code easier to read.
     */
    public String getUserName(Long userId) {
        Optional<User> user = findById(userId);
        return user.orElseThrow(IllegalStateException::new).getName();
    }
}
