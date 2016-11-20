package com.qweewp.java.lambda;

import com.qweewp.java.User;

import java.util.List;

public class Example3 {
    public void sortUsersById(List<User> users) {
        users.sort((x, y) -> Long.compare(x.getId(), y.getId()));
    }
}
