package org.example;

import java.io.IOException;
import java.io.OutputStream;

public class TestOutStream extends OutputStream {
    public String getMessageSent() {
        return messageSent;
    }

    private String messageSent;
    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {
        messageSent = new String(b);
    }
}
