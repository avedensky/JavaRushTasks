package com.javarush.task.task40.task4005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/* 
Сокетный сервер и клиент
*/

public class Client {
    private Connection connection;

    private String getServerAddress() {
        return "localhost";
    }

    private int getServerPort() {
        return 4444;
    }

    public void run() {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        try {
            connection = new Connection(new Socket(getServerAddress(), getServerPort()));

            SocketThread socketThread = new SocketThread();
            socketThread.setDaemon(true);
            socketThread.start();

            while (true) {
                String text = bis.readLine();
                if (text.equalsIgnoreCase("exit"))
                    break;
                connection.send(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String message = connection.receive();
                    System.out.println(message);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}