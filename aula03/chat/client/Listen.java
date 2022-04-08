package chat.client;

import java.util.Scanner;

public class Listen extends Thread {
    private Scanner input = null;
    private boolean running;

    public Listen(Scanner input) {
        this.input = input;
        running = true;
    }

    @Override
    public void run() {
        do {
            String resposta = input.nextLine();
            System.out.println("Recebido: " + resposta);
        } while (running);
    }

    public void parar(){
        running = false;
    }
}
