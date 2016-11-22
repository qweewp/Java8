package com.qweewp.java.stream;

import com.qweewp.java.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Example7Test {

    private Example7 example7 = new Example7();
    private Set<User> users = new HashSet<>();
    private static int totalAge = 0;

    @Before
    public void feelInputUsersListAndSetItToExample7Instance() {
        int firstUserAge = 15;
        int secondUserAge = 15;
        int thirdUserAge = 10;


        User firstUser = new User(1L, "Andrii");
        User secondUser = new User(2L, "Oleh");
        User thirdUser = new User(3L, "Oleksandr");

        firstUser.setAge(15);
        secondUser.setAge(15);
        thirdUser.setAge(10);

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

        totalAge += firstUserAge + secondUserAge + thirdUserAge;
        example7.getUsers().addAll(users);
    }

    @Test
    public void shouldGetTotalAgeFromUsersSet() {
        assertEquals(totalAge, example7.getTotalAge());
    }
}
