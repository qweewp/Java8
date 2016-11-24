package com.qweewp.java.stream;

import com.qweewp.java.User;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;

public class Example7 {
    private final Set<User> users = new HashSet<>();

    /**
     * Change:   Make calculation in a one line using {@link java.util.stream.Stream#mapToInt(ToIntFunction)}.
     */
    public int getTotalAge() {
        return users.stream().mapToInt(User::getAge).sum();
    }

    public Set<User> getUsers() {
        return users;
    }
}
