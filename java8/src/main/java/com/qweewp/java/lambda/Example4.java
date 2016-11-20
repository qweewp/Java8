package com.qweewp.java.lambda;

import com.qweewp.java.User;

import java.util.HashMap;
import java.util.Map;

public class Example4 {
    public Map<String, String> getUserNames(Map<String, User> users) {
        Map<String, String> userNames = new HashMap<>();
        users.entrySet().forEach(user ->
                userNames.put(user.getKey(), user.getValue().getName()));
        return userNames;
    }
}