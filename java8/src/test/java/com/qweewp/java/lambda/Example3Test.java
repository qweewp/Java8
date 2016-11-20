package com.qweewp.java.lambda;

import com.qweewp.java.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Example3Test {

    private Example3 example3 = new Example3();

    @Test
    public void shouldSortUsersById() {
        User firstUser = new User(2, "Andrii");
        User secondUser = new User(1, "Oleh");

        List<User> users = new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);

        List<User> sortedUsersById = new ArrayList<>();
        sortedUsersById.add(secondUser);
        sortedUsersById.add(firstUser);

        example3.sortUsersById(users);

        assertTrue(sortedUsersById.size() == users.size());
        assertEquals(sortedUsersById, users);
    }
}
