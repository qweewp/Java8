package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.qweewp.java.TestUtils.createSetOfUsersWithPermission;
import static org.junit.Assert.assertEquals;

public class Example1Test {

    private Example1 example1 = new Example1();

    private Set<User> inputUsers = new HashSet<>();

    @Before
    public void feelInputUsersList() {
        inputUsers.addAll(createSetOfUsersWithPermission(5, Permission.EDIT));
        inputUsers.addAll(createSetOfUsersWithPermission(5, Permission.ADD));
        inputUsers.addAll(createSetOfUsersWithPermission(5, Permission.SEARCH));
    }

    @Test
    public void shouldFindAllEditors() {
        int expectedCountOfEditPermissionUsers = 5;

        example1.getUsers().addAll(inputUsers);

        assertEquals(expectedCountOfEditPermissionUsers, example1.findEditors().size());
    }
}
