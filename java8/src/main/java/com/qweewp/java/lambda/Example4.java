package com.qweewp.java.lambda;

import com.qweewp.java.User;

import java.util.Map;
import java.util.stream.Collectors;

public class Example4 {

    /**
     * Change:  Use {@link Collectors} class to avoid explicit use of lambda without using forEach on the stream.
     */
    public Map<String, String> getUserNames(Map<String, User> users) {
        return users.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey, p -> p.getValue().getName()));

    }
}