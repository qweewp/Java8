package com.qweewp.java.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class Example6Test {

    private Example6 example6 = new Example6();

    private Example6.BusinessTransaction businessTransaction = mock(Example6.BusinessTransaction.class);

    private Example6.BusinessRule businessRule0 = mock(Example6.BusinessRule.class);
    private Example6.BusinessRule businessRule1 = mock(Example6.BusinessRule.class);

    private String businessRoleName0 = "businessRule0";
    private String businessRuleName1 = "businessRule1";


    @Before
    public void initBusinessRules() {
        when(businessRule0.getRuleName()).thenReturn(businessRoleName0);
        when(businessRule0.isPromotion()).thenReturn(true);

        when(businessRule1.getRuleName()).thenReturn(businessRuleName1);
        when(businessRule1.isPromotion()).thenReturn(false);
    }

    @Test
    public void shouldRetrieveOnePromoRuleName() {
        when(businessTransaction.getRules()).thenReturn(Arrays.asList(businessRule0, businessRule1));
        Set<String> promoRuleNames = example6.retrievePromoRuleNames(singletonList(businessTransaction));

        assertEquals(1, promoRuleNames.size());
        assertTrue(promoRuleNames.contains(businessRoleName0));
        assertFalse(promoRuleNames.contains(businessRuleName1));
    }

    @Test
    public void shouldNotRetrieveAnythingIfBusinessTransactionListIsEmpty() {
        Example6.BusinessTransaction businessRule = example6.new BusinessTransaction();

        example6.retrievePromoRuleNames(Collections.singletonList(businessRule));
    }

    @Test
    public void shouldNotRetrieveAnythingIfBusinessRuleIsNotPromotion() {
        Example6.BusinessRule businessRule = example6.new BusinessRule();

        when(businessTransaction.getRules()).thenReturn(Collections.singletonList(businessRule));

        Assert.assertEquals("", businessRule.getRuleName());
        Assert.assertFalse(businessRule.isPromotion());

        example6.retrievePromoRuleNames(Collections.singletonList(businessTransaction));
    }
}
