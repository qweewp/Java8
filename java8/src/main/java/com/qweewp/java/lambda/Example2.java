package com.qweewp.java.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Example2 {
    public void usage(AmbiguousService<String> service) {
        service.process(String::toUpperCase);
    }

    interface AmbiguousService<T> {
        <R> R process(Function<T, R> fn);

        T process(UnaryOperator<T> fn);
    }
}
