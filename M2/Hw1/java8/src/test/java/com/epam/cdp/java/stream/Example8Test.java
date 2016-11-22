package com.epam.cdp.java.stream;

import com.epam.cdp.java.entity.User;
import com.epam.cdp.java.entity.register.Register;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Example8Test {
    private Example8 example8 = new Example8();

    private Register registerMock = mock(Register.class);

    private List<User> users = new ArrayList<>();

    @Before
    public void init() {
        example8.setRegister(registerMock);
    }

    @Before
    public void fillUsersList() {
        users.add(new User(1L, "Andrii"));
        users.add(null);
        users.add(new User(3L, "Ivan"));
        users.add(new User(4L, "Alex"));
        users.add(null);
        users.add(new User(4L, "Alex"));
    }

    @Test
    public void shouldInvokeRegisterUserFourTimes() {
        assertEquals(registerMock, example8.getRegister());

        example8.registerUsers(users);

        verify(registerMock, times(4)).registerUser(any(User.class));
    }
}
