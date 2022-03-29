package server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        final int PORT = 1234;
        ServerSocket serverSocket;
        Socket clientSocket = null;
        Scanner input = null;
        PrintStream output = null;

        // criar o socket
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            System.out.println("Porta " + PORT + " indisponível.");
            System.out.println(e.getMessage());
            return;
        }

        // esperar a conexão
        try {
            System.out.println("Aguardando conexão...");
            clientSocket = serverSocket.accept();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // comunicação
        try {
            input = new Scanner(clientSocket.getInputStream());
            output = new PrintStream(clientSocket.getOutputStream());

            String msg;
            do {
                msg = input.nextLine();
                System.out.println("Recebido: " + msg);
                output.println("msg recebida.");
            } while (!msg.equals("exit"));

        } catch (Exception e) {
            System.out.println("Erro na comunicação");
            System.out.println(e.getMessage());
        }

        // encerrar conexão
        try {
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}