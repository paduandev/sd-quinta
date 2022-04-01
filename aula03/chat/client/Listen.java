package chat.client;

import java.util.Scanner;

public class Listen extends Thread {
    private Scanner input = null;

    public Listen(Scanner input) {
        this.input = input;
    }

    @Override
    public void run() {
        do {
            String resposta = input.nextLine();
            System.out.println("Recebido: " + resposta);
        } while (true);
    }
}
