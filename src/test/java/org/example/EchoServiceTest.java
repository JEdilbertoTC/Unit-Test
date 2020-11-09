package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;


class EchoServiceTest {
    @Test
    public void givenValidRequestWhenEchoThenTrue_isResponse() throws IOException {
        //Given
        EchoService echoService = new EchoService();
        String ip = "1.2";
        int port = 9988;
        String request = "HOLA MUNDO";
        //When
        TestOutStream outputStream = new TestOutStream();
        TestInputStream inputStream = new TestInputStream(request);
        boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);

        //Then
        String messageSent = outputStream.getMessageSent();
        assertEquals(request, messageSent);
        assertTrue(response);
    }
    @Test
    public void givenValidRequestAndWrongResponseWhenEchoThenTrue_isResponse() throws IOException {
        //Given
        EchoService echoService = new EchoService();
        String ip = "1.2";
        int port = 9988;
        String request = "HOLA MUNDO";
        //When
        TestOutStream outputStream = new TestOutStream();
        TestInputStream inputStream = new TestInputStream("Otra Cosa");
        boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);

        //Then
        String messageSent = outputStream.getMessageSent();
        assertEquals(request, messageSent);
        assertFalse(response);
    }
}