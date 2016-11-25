package com.qweewp.java.optional;

import com.qweewp.java.User;
import org.junit.Test;
import org.mockito.Mockito;


public class Example1Test {

    private Example1 example1 = new Example1();

    private Example1.Printer printerMock = Mockito.mock(Example1.Printer.class);

    @Test
    public void shouldCallPrintOnPrinterInstance() {
        User user = new User(1L, "Andrii");

        example1.setPrinter(printerMock);

        example1.process(user);

        Mockito.verify(printerMock, Mockito.times(1)).print(user);

    }

    @Test
    public void shouldCallPrintOnNullInstance() {
        User user = new User(1L, "Andrii");
        example1.process(user);

        Mockito.verify(printerMock, Mockito.times(0)).print(user);

    }
}
