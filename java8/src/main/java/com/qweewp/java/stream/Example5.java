package com.qweewp.java.stream;

import com.qweewp.java.logger.Logger;

import java.util.stream.IntStream;

public class Example5 {

    private Logger logger;

    /**
     * Change: Add parameter index. Because infinity loop is not a good approach.
     */
    public void iterate(int index) {
        IntStream.iterate(0, i -> i + 1)
                .limit(index)
                .forEach(logger::printObject);
    }

    /**
     * Change: Replace limit operation because we have an infinity loop if {@link IntStream#distinct()} goes before @{@link IntStream#limit(long)}. And add from and limit argument.
     *
     * @param from  start point of iterate.
     * @param limit limit
     */
    public void distinct(int from, int limit) {
        IntStream.iterate(from, i -> (i + 1) % 2)
                .limit(limit)
                .distinct()
                .forEach(logger::printObject);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
