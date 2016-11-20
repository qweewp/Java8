package com.qweewp.java.stream;

import java.util.stream.IntStream;

public class Example3 {
    // it intended to throw exception
    public void throwingAtTheEnd() {
        IntStream.range(1, 5)
                .peek(System.out::println)
                .peek(i -> {
                    if (i == 5)
                        throw new RuntimeException("bang");
                });
    }
}
