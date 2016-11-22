package com.epam.cdp.java.lambda;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class Example2Test {

    private Example2 example2 = new Example2();

    private Example2.AmbiguousService<String> ambiguousServiceMock = mock(Example2.AmbiguousService.class);

    @Test
    public void shouldInvokeProcessMethod() {

        example2.usage(ambiguousServiceMock);

        verify(ambiguousServiceMock, times(1)).change(Mockito.any());

    }
}
