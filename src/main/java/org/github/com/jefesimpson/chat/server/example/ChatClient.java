package org.github.com.jefesimpson.chat.server.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        try(Socket client = new Socket("127.0.0.1", 3232)){
            Scanner sc = new Scanner(System.in);
            while (true) {
                PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
                printWriter.println(sc.nextLine());

                InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
                Scanner scanner = new Scanner(inputStreamReader);
                System.out.println("server: " + scanner.nextLine());
            }

        }
    }
}
