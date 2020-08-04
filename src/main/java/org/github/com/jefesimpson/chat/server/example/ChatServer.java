package org.github.com.jefesimpson.chat.server.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(3232)){
            while(true){
                try(Socket client = serverSocket.accept()){
                    while(true) {
                        InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
                        Scanner sc = new Scanner(System.in);
                        Scanner scanner = new Scanner(inputStreamReader);
                        System.out.println("client: " + scanner.nextLine());

                        PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
                        printWriter.println(sc.nextLine());
                    }
                }
            }
        }

    }
}
