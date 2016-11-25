package com.epam.cdp.java.optional;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Example2Test {

    private Example2 example2 = new Example2();
    private Example2.Email firstEmail;
    private Example2.Email secondEmail;

    @Before
    public void createEmailsAndTestReturnValues() {
        String attachmentPath = "/mnt/files/image.png";
        int attachmentSize = 370;
        String firstSubject = "First!";
        String secondSubject = "Second!";
        String firstBody = "No attachment";
        String secondBody = "With attachment";

        Example2.Attachment attachment = example2.new Attachment(attachmentPath, attachmentSize);

        assertEquals(attachmentPath, attachment.getPath());
        assertEquals(attachmentSize, attachment.getSize());


        firstEmail = example2.new Email(firstSubject, firstBody);
        secondEmail = example2.new Email(secondSubject, secondBody, attachment);

        assertEquals(firstSubject, firstEmail.getSubject());
        assertEquals(firstBody, firstEmail.getBody());

        assertEquals(secondSubject, secondEmail.getSubject());
        assertEquals(secondBody, secondEmail.getBody());

    }

    @Test
    public void shouldCheckCreatedEmailInCreateStandardEmailsMethod() {

        ArrayList<Example2.Email> expectedList = new ArrayList<>();
        expectedList.add(firstEmail);
        expectedList.add(secondEmail);

        List<Example2.Email> actualList = example2.createStandardEmails();

        assertTrue(actualList.size() == 2);
        assertFalse(secondEmail.getAttachment() == null);
        assertTrue(firstEmail.getAttachment() == null);

        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(expectedList.get(i).getBody(), actualList.get(i).getBody());
            Assert.assertEquals(expectedList.get(i).getSubject(), actualList.get(i).getSubject());
        }
    }
}
