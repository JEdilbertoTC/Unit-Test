package org.example;

import java.io.IOException;
import java.io.InputStream;

public class TestInputStream extends InputStream {
    private String messageRespond;
    @Override
    public int read() throws IOException {
        return 0;
    }

    public TestInputStream(String messageRespond) {
        this.messageRespond = messageRespond;
    }

    @Override
    public byte[] readAllBytes() throws IOException {
        return messageRespond.getBytes();
    }
}
