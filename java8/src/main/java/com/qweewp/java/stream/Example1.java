package com.qweewp.java.stream;

import com.qweewp.java.Permission;
import com.qweewp.java.User;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Example1 {
    private final Set<User> users = new HashSet<>();

    /**
     * Change:  Make the code easiest to read using @{@link Collectors#groupingBy(Function, Collector)}.
     */
    public Map<String, Set<User>> findEditors() {
        return users.stream()
                .flatMap(user -> user.getRoles().stream()
                        .filter(role -> role.getPermissions().contains(Permission.EDIT))
                        .map(role -> new SimpleImmutableEntry<>(role.getName(), user)))
                .collect(Collectors.groupingBy(SimpleImmutableEntry::getKey, Collectors.mapping(SimpleImmutableEntry::getValue, toSet())));
    }

    public Set<User> getUsers() {
        return users;
    }
}
