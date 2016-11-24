package com.qweewp.java.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Example0Test {

    private Example0 example0 = new Example0();

    private Example0.Order orderMock = mock(Example0.Order.class);
    private Example0.Status status = example0.new Status();

    @Test
    public void shouldFilterOrderByStatuses() {
        when(orderMock.getStatus()).thenReturn(status);

        List<Example0.Order> orders = Collections.singletonList(orderMock);
        HashSet<Example0.Status> appropriateStatuses = new HashSet<>(Collections.singletonList(status));

        int expectedFilteredSize = 1;
        assertEquals(expectedFilteredSize, example0.filterOrdersByStatuses(orders, appropriateStatuses).size());
    }

    @Test
    public void shouldReturnNothingIfStatusIsNull() {
        Example0.Order order = example0.new Order();
        List<Example0.Order> filteredOrdersByStatuses = example0.filterOrdersByStatuses(Collections.singletonList(order), Collections.singleton(status));

        Assert.assertNull(order.getStatus());

        Assert.assertTrue(filteredOrdersByStatuses.isEmpty());
    }
}
