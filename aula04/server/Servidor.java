package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        final int PORTA = 9876;
        ServerSocket server;

        try {
            server = new ServerSocket(PORTA);

            while (true) {
                System.out.println("Aguardando conexão...");
                Socket cliente = server.accept();
                System.out.println("Conectado com " + cliente.getInetAddress().getHostAddress());
                Calcula calcula = new Calcula(cliente);
                calcula.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
