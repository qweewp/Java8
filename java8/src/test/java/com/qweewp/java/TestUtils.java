package com.qweewp.java;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TestUtils {

    /**
     * Creates define count of users with define permission.
     *
     * @param countOfUsers count of users
     * @param permission   permission for each user
     * @return set of users
     */
    public static Set<User> createSetOfUsersWithPermission(int countOfUsers, Permission permission) {
        Set<User> collection = new HashSet<>();
        for (int i = 0; i < countOfUsers; i++) {
            User user = new User(i, "User" + i);
            Role role = createRole("Role" + i, permission);
            user.getRoles().add(role);
            collection.add(user);
        }
        return collection;
    }

    /**
     * Creates role.
     *
     * @param name       role name
     * @param permission role permission
     * @return role instance
     */
    public static Role createRole(String name, Permission permission) {
        Role role = new Role();
        role.setName(name);
        role.setPermissions(EnumSet.of(permission));
        return role;
    }
}

