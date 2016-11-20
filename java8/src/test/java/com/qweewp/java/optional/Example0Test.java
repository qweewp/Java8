package com.qweewp.java.optional;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Example0Test {

    private static final String UNKNOWN = "Unknown";
    private static final String NAME = "Chevrolet Impala 1967";
    private static final String EMPTY = "";

    private Example0 example0 = new Example0();

    private Example0.Person personStyleMock = mock(Example0.Person.class);
    private Example0.Car carMock = mock(Example0.Car.class);
    private Example0.Insurance insuranceMock = mock(Example0.Insurance.class);

    private Example0.ImperativeStyle imperativeStyle = example0.new ImperativeStyle();
    private Example0.UsingIfPresent usingIfPresent = example0.new UsingIfPresent();
    private Example0.UsingGet usingGet = example0.new UsingGet();
    private Example0.UsingOrElse usingOrElse = example0.new UsingOrElse();

    @Before
    public void initStubs() {
        when(personStyleMock.getCar()).thenReturn(Optional.of(carMock));
        when(carMock.getInsurance()).thenReturn(Optional.of(insuranceMock));
        when(insuranceMock.getName()).thenReturn(NAME);
    }

    @Test
    public void shouldReturnUnknownStringUsingImperativeStyle() {
        assertEquals(UNKNOWN, imperativeStyle.getPersonCarInsuranceName(null));
    }

    @Test
    public void shouldReturnUserNameUsingImperativeStyle() {
        assertEquals(NAME, imperativeStyle.getPersonCarInsuranceName(personStyleMock));

    }

    @Test
    public void shouldReturnUnknownStringUsingIfPresent() {
        assertEquals(EMPTY, usingIfPresent.getPersonCarInsuranceName(null));
    }

    @Test
    public void shouldReturnUserNameUsingUsingIfPresent() {
        assertEquals(NAME, usingIfPresent.getPersonCarInsuranceName(personStyleMock));
    }

    @Test
    public void shouldReturnUnknownStringUsingGet() {
        assertEquals(UNKNOWN, usingGet.getPersonCarInsuranceName(null));
    }

    @Test
    public void shouldReturnUserNameUsingUsingGet() {
        assertEquals(NAME, usingGet.getPersonCarInsuranceName(personStyleMock));
    }

    @Test
    public void shouldReturnUnknownStringUsingOrElse() {
        assertEquals(UNKNOWN, usingOrElse.getPersonCarInsuranceName(null));
    }

    @Test
    public void shouldReturnUserNameUsingUsingOrElse() {
        assertEquals(NAME, usingOrElse.getPersonCarInsuranceName(personStyleMock));
    }

}
