package com.qweewp.java.optional;

import com.qweewp.java.User;

import static java.util.Optional.ofNullable;

public class Example3 {
    class BeforeJava8 {
        public String getUserName(User user) {
            return (user != null && user.getName() != null) ? user.getName() : "default";
        }
    }

    class UsingOptionalIsPresent {
        public String getUserName(User user) {
            if (ofNullable(user).isPresent()) {
                if (ofNullable(user.getName()).isPresent()) {
                    return user.getName();
                }
            }
            return "default";
        }
    }
}
