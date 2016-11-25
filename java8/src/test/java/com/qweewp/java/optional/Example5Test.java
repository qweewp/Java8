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

    private User expectedUser = new User(5L, "Oleh");

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetUserNameMethodIsInvoke() throws Exception {
        expectPrivate(partialMock, "findById", expectedUser.getId()).andReturn(Optional.empty());
        replay(partialMock);

        partialMock.getUserName(5L);

        verify(partialMock);
    }

    @Test
    public void shouldReturnUserById() throws Exception {
        Optional<User> privateMethodReturn = Optional.of(expectedUser);

        expectPrivate(partialMock, "findById", expectedUser.getId()).andReturn(privateMethodReturn);
        replay(partialMock);

        String userName = partialMock.getUserName(5L);
        assertEquals(userName, expectedUser.getName());

        verify(partialMock);
    }

    @Test
    public void shouldReturnUserOnClassStub() {
        Example5 example5 = new Example5();

        String actualUser = example5.getUserName(5L);

        assertEquals(expectedUser.getName(), actualUser);
    }
}
