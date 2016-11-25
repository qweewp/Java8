package com.qweewp.java.stream;

import com.qweewp.java.logger.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class Example3Test {

    private Example3 example3 = new Example3();

    private Logger loggerMock = mock(Logger.class);

    @Before
    public void init() {
        example3.setLogger(loggerMock);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionException() {
        assertEquals(loggerMock, example3.getLogger());

        example3.throwingAtTheEnd(5);

        verify(loggerMock, times(5)).printObject(Mockito.anyObject());
    }
}
