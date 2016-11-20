package com.qweewp.java.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example9 {
    public void reuseStream() {
        int[] array = new int[]{1, 2};
        IntStream stream = Arrays.stream(array);
        stream.forEach(System.out::println);
        array[0] = 2;
        stream.forEach(System.out::println);
    }
}
