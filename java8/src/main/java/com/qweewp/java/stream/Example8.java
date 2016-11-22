package com.qweewp.java.stream;

import com.qweewp.java.User;
import com.qweewp.java.register.Register;

import java.util.Collection;
import java.util.Objects;

public class Example8 {

    private Register register;

    /**
     * Change:  Remove usages of Optional class. Make the code easier to read.
     */
    public void registerUsers(Collection<User> users) {
        users.stream()
                .filter(Objects::nonNull)
                .forEach(register::registerUser);
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
