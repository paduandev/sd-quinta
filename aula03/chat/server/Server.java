package chat.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private static ArrayList<Attend> threads;

    public static void main(String[] args) {
        final int PORT = 1234;
        ServerSocket serverSocket;
        Socket clientSocket = null;


        // criar o socket
        try {
            serverSocket = new ServerSocket(PORT);
            threads = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Porta " + PORT + " indisponível.");
            System.out.println(e.getMessage());
            return;
        }

        // esperar a conexão
        try {
            do {
                System.out.println("Aguardando conexão...");
                clientSocket = serverSocket.accept();
                Attend attend = new Attend(clientSocket, threads);
                attend.start();
                threads.add(attend);
            } while (true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // encerrar conexão
        // try {
        //     clientSocket.close();
        //     serverSocket.close();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

    }
}