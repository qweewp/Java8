package com.qweewp.java.stream;


import com.qweewp.java.logger.Logger;

import java.util.stream.IntStream;

public class Example3 {

    private Logger logger;

    /**
     * Change:  Remove peek calls because they are intermediate operation and do nothing without terminal operation invoke.
     */
    // it intended to throw exception
    public void throwingAtTheEnd(Integer endPoint) {
        IntStream.rangeClosed(1, endPoint)
                .peek(logger::printObject)
                .filter(value -> value > endPoint)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
