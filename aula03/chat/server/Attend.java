package chat.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Attend extends Thread {
    private Socket clientSocket;
    private ArrayList<Attend> threads;
    Scanner input = null;
    PrintStream output = null;

    public Attend(Socket clientSocket, ArrayList<Attend> threads) {
        this.clientSocket = clientSocket;
        this.threads = threads;
    }

    @Override
    public void run() {
        // comunicação
        try {
            input = new Scanner(clientSocket.getInputStream());
            output = new PrintStream(clientSocket.getOutputStream());

            String msg;
            do {
                msg = input.nextLine();
                System.out.println("Recebido: " + msg);
                for (Attend attend : threads) {
                    attend.sendMessage(msg);
                }
            } while (!msg.equals("exit"));

            input.close();
            output.close();

        } catch (Exception e) {
            System.out.println("Erro na comunicação");
            System.out.println(e.getMessage());
        }
    }

    public void sendMessage(String msg) {
        output.println(msg);
    }
}
