package com.qweewp.java.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Example2 {


    public void usage(AmbiguousService<String> service) {
        service.change(String::toUpperCase);
    }

    /**
     * Change:  change method name, because we do not know which of this will be invoke.
     */
    interface AmbiguousService<T> {
        <R> R change(Function<T, R> fn);

        T process(UnaryOperator<T> fn);
    }
}
