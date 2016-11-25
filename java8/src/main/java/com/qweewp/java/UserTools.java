package com.qweewp.java;

/**
 * Additional methods for {@link User}
 */
public class UserTools {

    public static boolean hasEditPermission(User user) {
        return user.getRoles().stream().anyMatch(role -> role.getPermissions().contains(Permission.EDIT));
    }
}
