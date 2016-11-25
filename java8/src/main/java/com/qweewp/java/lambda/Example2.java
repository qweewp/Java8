package com.qweewp.java.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Example2 {


    public void usage(AmbiguousService<String> service) {
        service.change(String::toUpperCase);
    }

    /**
     * Change:  Change method name, because if we pass a method reference(for example String::toUpperCase)
     * to this method we always invoke method with <code> UnaryOperator<T>fn </> signature.
     */
    interface AmbiguousService<T> {
        <R> R change(Function<T, R> fn);

        T process(UnaryOperator<T> fn);
    }
}
