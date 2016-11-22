package com.qweewp.java.stream;

import com.qweewp.java.logger.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class Example9Test {

    private Example9 example9 = new Example9();

    private Logger loggerMock = mock(Logger.class);

    @Before
    public void init() {
        example9.setLogger(loggerMock);
    }

    @Test
    public void shouldNotThrowExceptionUsingStreamSupplier() {
        assertEquals(loggerMock, example9.getLogger());

        example9.reuseStream();

        verify(loggerMock, times(4)).printObject(anyObject());
    }
}
