package com.qweewp.java.lambda;

import com.qweewp.java.Permission;
import com.qweewp.java.TestUtils;
import com.qweewp.java.User;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Example0Test {

    private Example0 example0 = new Example0();

    @Test
    public void shouldReturnEmptyListIfAdminInNotPresentInTheList() {
        assertTrue(example0.findEditors().isEmpty());
    }

    @Test
    public void shouldReturnUsersWithEditPermission() {
        Integer countOfEditPermissionUser = 5;
        Set<User> setOfUsersWithPermission = TestUtils.createSetOfUsersWithPermission(countOfEditPermissionUser, Permission.EDIT);

        example0.getUsers().addAll(setOfUsersWithPermission);

        assertEquals(5, example0.findEditors().size());
    }
}
