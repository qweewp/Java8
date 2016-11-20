package com.qweewp.java.optional;

import com.qweewp.java.User;

public class Example1 {
    private Printer printer;

    public void process(User user) {
        //some processing
        if (printer != null) {
            printer.print(user);
        }
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    interface Printer {
        void print(User user);
    }
}
