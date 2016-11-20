package com.qweewp.java.optional;

import com.qweewp.java.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.easymock.PowerMock.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Example4.class)
public class Example4Test {

    private Example4 example4 = createPartialMock(Example4.class, "findUsersByRole");

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenInvokeFindAnyAdmin() throws Exception {
        Optional<ArrayList<Object>> expectedReturnValue = Optional.of(new ArrayList<>());
        expectPrivate(example4, "findUsersByRole", "admin").andReturn(expectedReturnValue);

        replay(example4);

        example4.findAnyAdmin();

        verify(example4);
    }

    @Test
    public void shouldFindAnyAdmin() throws Exception {
        User expectedAdminUser = new User(1L, "Andrii");
        Optional<List<User>> returnOptional = Optional.of(Collections.singletonList(expectedAdminUser));

        expectPrivate(example4, "findUsersByRole", "admin").andReturn(returnOptional);

        replay(example4);

        User admin = example4.findAnyAdmin();
        assertNotNull(admin);
        assertEquals(expectedAdminUser, admin);

        verify(example4);
    }
}
