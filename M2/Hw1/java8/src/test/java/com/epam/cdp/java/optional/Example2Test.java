package com.epam.cdp.java.optional;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Example2Test {
    private Example2 example2 = new Example2();

    @Test
    public void shouldCheckCreatedEmailInCreateStandardEmailsMethod() {

        ArrayList<Example2.Email> expectedList = new ArrayList<>();
        Example2.Attachment attachment = example2.new Attachment("/mnt/files/image.png", 370);
        expectedList.add(example2.new Email("First!", "No attachment"));
        expectedList.add(example2.new Email("Second!", "With attachment", attachment));

        List<Example2.Email> actualList = example2.createStandardEmails();

        assertTrue(actualList.size() == 2);

        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(expectedList.get(i).getBody(), actualList.get(i).getBody());
            Assert.assertEquals(expectedList.get(i).getSubject(), actualList.get(i).getSubject());
        }
    }
}
