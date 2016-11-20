package com.qweewp.java.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example6 {
    public Set<String> retrievePromoRuleNames(List<BusinessTransaction> transactions) {
        Set<String> ruleNamesWithPromo = new HashSet<>();
        transactions.forEach(transaction -> transaction.getRules().stream()
                .filter(BusinessRule::isPromotion)
                .forEach(rule -> ruleNamesWithPromo.add(rule.getRuleName())));
        return ruleNamesWithPromo;
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
