package com.qweewp.java.lambda;

import com.qweewp.java.User;

import java.util.Comparator;
import java.util.List;

public class Example3 {

    /**
     * Change:  Use {@link Comparator#comparing} method which makes sort method the code easier to read.
     */
    public void sortUsersById(List<User> users) {
        users.sort(Comparator.comparing(User::getId));
    }
}
