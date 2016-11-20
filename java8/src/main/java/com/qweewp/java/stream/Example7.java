package com.qweewp.java.stream;

import com.qweewp.java.User;

import java.util.HashSet;
import java.util.Set;

public class Example7 {
    private final Set<User> users = new HashSet<>();

    public int getTotalAge() {
        return users.stream()
                .map(User::getAge)
                .reduce(0, Integer::sum);
    }
}
