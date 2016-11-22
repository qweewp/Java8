package com.qweewp.java.optional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Example2 {

    /**
     * Change:  Remove Option class from method arguments, overload constructor in class Email which makes the code easier to read.
     */
    public List<Email> createStandardEmails() {
        Attachment attachment = new Attachment("/mnt/files/image.png", 370);
        Email noAttachment = new Email("First!", "No attachment");
        Email withAttachment = new Email("Second!", "With attachment", attachment);
        return Arrays.asList(noAttachment, withAttachment);
    }

    class Email implements Serializable {
        private final String subject;
        private final String body;
        private Attachment attachment;

        public Email(String subject, String body, Attachment attachment) {
            this.subject = subject;
            this.body = body;
            this.attachment = attachment;
        }

        public Email(String subject, String body) {
            this.subject = subject;
            this.body = body;
        }

        public String getSubject() {
            return subject;
        }

        public String getBody() {
            return body;
        }

        public Attachment getAttachment() {
            return attachment;
        }
    }

    class Attachment {
        private final String path;
        private final int size;

        public Attachment(String path, int size) {
            this.path = path;
            this.size = size;
        }

        public String getPath() {
            return path;
        }

        public int getSize() {
            return size;
        }
    }
}
