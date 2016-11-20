package com.qweewp.java.stream;

import org.junit.Test;

public class Example9Test {

    private Example9 example9 = new Example9();

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionCauseReuseStream() {
        example9.reuseStream();
    }
}
