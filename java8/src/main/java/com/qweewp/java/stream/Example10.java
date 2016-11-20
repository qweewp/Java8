package com.qweewp.java.stream;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Example10 {
    public Map<String, Object> getJpaProperties() {
        return Collections.unmodifiableMap(
                Stream.of(
                        new AbstractMap.SimpleEntry<>("hibernate.show_sql", "true"),
                        new AbstractMap.SimpleEntry<>("hibernate.format_sql", "true")
                ).collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
        );
    }
}
