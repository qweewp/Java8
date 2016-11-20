package com.qweewp.java.optional;

import com.qweewp.java.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Example5.class)
public class Example5Test {

    private Example5 partialMock = createPartialMock(Example5.class, "findById");

    private User user = new User(5L, "Oleh");

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetUserNameMethodIsInvoke() throws Exception {
        expectPrivate(partialMock, "findById", user.getId()).andReturn(Optional.empty());
        replay(partialMock);

        partialMock.getUserName(5L);

        verify(partialMock);
    }

    @Test
    public void shouldReturnUserById() throws Exception {
        Optional<User> privateMethodReturn = Optional.of(user);

        expectPrivate(partialMock, "findById", user.getId()).andReturn(privateMethodReturn);
        replay(partialMock);

        String userName = partialMock.getUserName(5L);
        assertEquals(userName, user.getName());

        verify(partialMock);

    }
}
