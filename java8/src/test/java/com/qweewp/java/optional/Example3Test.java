package com.qweewp.java.optional;

import com.qweewp.java.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Example3Test {

    private static final String DEFAULT_RETURN = "default";

    private Example3 example3 = new Example3();

    private Example3.BeforeJava8 beforeJava8 = example3.new BeforeJava8();
    private Example3.UsingOptionalIsPresent optionalIsPresent = example3.new UsingOptionalIsPresent();

    private User user = new User(1L, "Andrii");

    @Test
    public void shouldGetUserName() {
        assertEquals(user.getName(), beforeJava8.getUserName(user));
    }

    @Test
    public void shouldReturnDefaultValueUsingBeforeJava8Class() {
        assertEquals(DEFAULT_RETURN, beforeJava8.getUserName(null));
    }

    @Test
    public void shouldGetUserNameUsingUsingOptionalIsPresentClass() {
        assertEquals(user.getName(), optionalIsPresent.getUserName(user));
    }

    @Test
    public void shouldReturnDefaultValueUsingUsingOptionalIsPresentClass() {
        assertEquals(DEFAULT_RETURN, optionalIsPresent.getUserName(null));
    }
}
