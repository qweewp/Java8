package com.qweewp.java.optional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example2 {
    public List<Email> create() {
        Email noAttachment = new Email("First!", "No attachment", Optional.empty());
        Attachment attachment = new Attachment("/mnt/files/image.png", 370);
        Email withAttachment = new Email("Second!", "With attachment", Optional.of(attachment));
        return Arrays.asList(noAttachment, withAttachment);
    }

    class Email implements Serializable {
        private final String subject;
        private final String body;
        private final Optional<Attachment> attachment;

        public Email(String subject, String body, Optional<Attachment> attachment) {
            this.subject = subject;
            this.body = body;
            this.attachment = attachment;
        }

        public String getSubject() {
            return subject;
        }

        public String getBody() {
            return body;
        }

        public Optional<Attachment> getAttachment() {
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
