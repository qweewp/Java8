package com.qweewp.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example6 {

    /**
     * Change:  Make the code easiest to read by creating result Set using {@link Collectors#toSet()} method.
     */
    public Set<String> retrievePromoRuleNames(List<BusinessTransaction> transactions) {
        return transactions.stream()
                .flatMap(transaction -> transaction.getRules().stream())
                .filter(BusinessRule::isPromotion)
                .map(BusinessRule::getRuleName)
                .collect(Collectors.toSet());
    }

    class BusinessTransaction {
        List<BusinessRule> getRules() {
            return new ArrayList<>(); //stub
        }
    }

    class BusinessRule {
        String getRuleName() {
            return ""; //stub
        }

        boolean isPromotion() {
            return false; //stub
        }
    }
}
