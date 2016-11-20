package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.Role;
import com.qweewp.java.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.qweewp.java.TestUtils.createRole;
import static org.junit.Assert.assertTrue;

public class Example4Test {

    private Example4 example4 = new Example4();

    private List<User> users = new ArrayList<>();

    @Before
    public void feelInputUsersList() {
        User user = new User(1L, "Andrii");
        Set<Role> roles = new HashSet<>();
        roles.add(createRole("admin", Permission.ADD));

        user.setRoles(roles);
        users.add(user);
    }

    @Test
    public void shouldReturnTrueWhenInvokeFindAdminMethod() {
        example4.getUsers().addAll(users);
        assertTrue(example4.hasAdmin());
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenUsersListHasNullUser() {
        List<User> nullUsers = new ArrayList<>();
        nullUsers.add(null);

        example4.getUsers().addAll(nullUsers);

        example4.hasAdmin();
    }
}
