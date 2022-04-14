package client;

import java.net.Socket;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Cliente {
    public static void main(String[] args) {
        final int PORTA = 9876;
        final String IP = "127.0.0.1";
        Socket socket;

        try {
            socket = new Socket(IP, PORTA);
            Requisicao requisicao = new Requisicao(3, 5, '+');

            Comunicacao comunicacao = new Comunicacao(socket);

            comunicacao.enviar(requisicao);

            Resposta resposta = (Resposta) comunicacao.receber();

            if(resposta.getStatus() == Resposta.OK) {
                System.out.println("Resultado: " + resposta.getValor());
            } else {
                if(resposta.getStatus() == Resposta.OPERADOR_INVALIDO) {
                    System.out.println("Operador desconhecido.");
                } else {
                    System.out.println("Erro! Divisão por zero.");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
