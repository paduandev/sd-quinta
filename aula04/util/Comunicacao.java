package util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Comunicacao {
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Comunicacao(Socket socket) {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void enviar(Object obj) {
        try {
            output.writeObject(obj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Object receber() {
        try {
            return input.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
