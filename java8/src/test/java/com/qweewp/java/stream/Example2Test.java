package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.qweewp.java.TestUtils.createSetOfUsersWithPermission;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Example2Test {

    private Example2 example2 = new Example2();
    private Set<User> users = new HashSet<>();

    @Before
    public void feelInputUsersSetAndSetItToExample2Instance() {
        int countOfEditPermissionUser = 4;
        users.addAll(createSetOfUsersWithPermission(countOfEditPermissionUser, Permission.EDIT));
        example2.getUsers().addAll(users);
    }

    @Test
    public void shouldReturnTrueWhileCheckUserWithEditPermission() {
        assertTrue(example2.checkPermission(Permission.EDIT));
    }

    @Test
    public void shouldReturnFalseWhileCheckUserWithAddPermission() {
        assertFalse(example2.checkPermission(Permission.ADD));
    }
}
