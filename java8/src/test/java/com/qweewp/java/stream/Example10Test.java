package com.qweewp.java.stream;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Example10Test {

    private Example10 example10 = new Example10();

    @Test
    public void shouldReturnMapWithJpaProperties() {
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("hibernate.format_sql", "true");
        expectedMap.put("hibernate.show_sql", "true");

        assertEquals(expectedMap, example10.getJpaProperties());
    }
}
