package com.qweewp.java.lambda;

import com.qweewp.java.User;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Example4Test {

    private Example4 example4 = new Example4();

    @Test
    public void shouldReturnString_UserName_Map() {
        HashMap<String, User> inputMap = new HashMap<>();
        inputMap.put("first", new User(1L, "Andrii"));
        inputMap.put("second", new User(2L, "Sasha"));

        HashMap<String, String> expectedMap = new HashMap<>();
        expectedMap.put("first", "Andrii");
        expectedMap.put("second", "Sasha");

        assertEquals(expectedMap, example4.getUserNames(inputMap));

    }
}
