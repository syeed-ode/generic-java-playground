package com.syeedode.security.ssl;

import com.syeedode.annotations.ThreadSafe;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.syeedode.security.common.ArgumentValidator.SERVER_OUTPUT_STRING;

/**
 * O'Reilly Java Security Second Edition
 * SSL Client and Server Sockets - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
@ThreadSafe
public class SSLServer extends Thread {
    private final Socket socket;

    /** * Static factory metnods */
    public static SSLServer getInstance(Socket s) {
        return new SSLServer(s);
    }

    private SSLServer(Socket sock) {
        socket = sock;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader in = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(in);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            String data = br.readLine();
            System.out.println("Client asked: " + data);
            printWriter.println(SERVER_OUTPUT_STRING);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runSSLServer() {
        ServerSocketFactory serverSocketFactory = SSLServerSocketFactory.getDefault();
        try {
            ServerSocket serverSocket = serverSocketFactory.createServerSocket(9096);

            while (true) {
                getInstance(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
