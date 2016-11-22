package com.qweewp.java.stream;

import com.qweewp.java.logger.Logger;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Example9 {

    private Logger logger;

    /**
     * Change:  Add ${@link Supplier} which allow to use one {@link java.util.stream.Stream} many times.
     */
    public void reuseStream() {
        int[] array = new int[]{1, 2};
        Supplier<IntStream> streamSupplier = () -> Arrays.stream(array);
        streamSupplier.get().forEach(logger::printObject);
        array[0] = 2;
        streamSupplier.get().forEach(logger::printObject);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
