package com.qweewp.java.stream;

import com.qweewp.java.User;

import java.util.Collection;

import static java.util.Optional.ofNullable;

public class Example8 {
    public void registerUsers(Collection<User> users) {
        users.stream().forEach(user ->
                ofNullable(user).ifPresent(u -> {
                    //register user
                })
        );
    }

}
