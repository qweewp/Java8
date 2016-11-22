package com.epam.cdp.java.stream;

import com.epam.cdp.java.entity.logger.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class Example5Test {

    private Example5 example5 = new Example5();
    private Logger loggerMock = Mockito.mock(Logger.class);

    @Before
    public void init() {
        example5.setLogger(loggerMock);
    }

    @Test
    public void shouldIterateCallLoggingTwoTimes() {
        int expectedCalls = 2;
        int from = 0;

        example5.distinct(from, 10);

        verify(loggerMock, Mockito.times(expectedCalls)).printObject(Mockito.anyObject());
    }

    @Test
    public void shouldLoggingEachIteration() {
        int iterateCount = 5;

        example5.iterate(iterateCount);

        verify(loggerMock, Mockito.times(iterateCount)).printObject(Mockito.anyObject());
    }
}
