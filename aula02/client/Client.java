package client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String IP = "127.0.0.1";
        final int PORT = 1234;
        Socket socket = null;
        Scanner input = null;
        Scanner teclado;
        PrintStream output = null;
        
        // solicitar conexão
        try {
            socket = new Socket(IP, PORT);
        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao servidor.");
            System.out.println(e.getMessage());
            return;
        }
        
        // comunicação
        try {
            input = new Scanner(socket.getInputStream());
            output = new PrintStream(socket.getOutputStream());

            teclado = new Scanner(System.in);
            String msg;
            
            do {
                System.out.print("Digite a menssagem: ");
                msg = teclado.nextLine();
                output.println(msg);
                String resposta = input.nextLine();
                System.out.println("Recebido: " + resposta);
            } while (!msg.equalsIgnoreCase("exit"));

            teclado.close();

        } catch (Exception e) {
            System.out.println("Erro na comunicação");
            System.out.println(e.getMessage());
        }
        
        // encerrar conexão
        try {
            input.close();
            output.close();
            socket.close();         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
