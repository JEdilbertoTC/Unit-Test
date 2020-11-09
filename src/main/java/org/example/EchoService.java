package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoService {
    public boolean echo(String ip, int port, String message){
        try {
            Socket socket = new Socket(ip,port);
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            return sendEchoMessage(message, os, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendEchoMessage(String message, OutputStream os, InputStream is) throws IOException {
        os.write(message.getBytes());
        String messageReceives = new String(is.readAllBytes());

        return messageReceives.equals(message);
    }
}
