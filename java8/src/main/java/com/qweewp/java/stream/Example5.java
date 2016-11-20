package com.qweewp.java.stream;

import java.util.stream.IntStream;

public class Example5 {
    public void iterate() {
        IntStream.iterate(0, i -> i + 1)
                .forEach(System.out::println);
    }

    public void distinct() {
        IntStream.iterate(0, i -> (i + 1) % 2)
                .distinct()
                .limit(10)
                .forEach(System.out::println);
    }
}
