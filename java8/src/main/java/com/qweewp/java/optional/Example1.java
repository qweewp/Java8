package com.qweewp.java.optional;

import com.qweewp.java.User;

import java.util.Optional;

public class Example1 {
    private Printer printer;

    /**
     * Change:  Use {@link Optional} class for check user for null instead of if statement.
     */
    public void process(User user) {
        //some processing
        Optional.ofNullable(printer).
                ifPresent(pr -> pr.print(user));
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    interface Printer {
        void print(User user);
    }
}
