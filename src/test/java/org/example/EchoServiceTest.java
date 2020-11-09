package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EchoServiceTest {
    @Test
    public void givenValidRequestWhenEchoThenTrue_isResponse() throws IOException {
        //Given
        EchoService echoService = new EchoService();
        String request = "hola mundo";
        byte [] messageinBytes = new byte[]{'h','o','l','a',' ', 'm','u','n','d','o'};
        OutputStream outputStream = mock(OutputStream.class);
        InputStream inputStream = mock(InputStream.class);
        when(inputStream.readAllBytes()).thenReturn(messageinBytes);

        //When
        boolean response = echoService.sendEchoMessage(request,outputStream,inputStream);

        //Then
        verify(inputStream).readAllBytes();
        verify(outputStream).write(messageinBytes);
        verifyNoMoreInteractions(inputStream,outputStream);
        assertTrue(response);
    }
    @Test
    public void givenValidRequestAndWrongResponseWhenEchoThenTrue_isResponse() throws IOException {
        //Given
        EchoService echoService = new EchoService();
        String request = "hola mundo";
        byte [] messageRequest = new byte[]{'h','o','l','a',' ', 'm','u','n','d','o'};
        byte [] messageRespond = new byte[]{'h','o','l','a',' ', 'm','u','n','d','o','2'};

        OutputStream outputStream = mock(OutputStream.class);
        InputStream inputStream =  mock(InputStream.class);
        when(inputStream.readAllBytes()).thenReturn(messageRespond);

        //When
        boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);

        //Then
        verify(inputStream).readAllBytes();
        verify(outputStream).write(messageRequest);
        verifyNoMoreInteractions(inputStream, outputStream);

        assertFalse(response);
    }
}