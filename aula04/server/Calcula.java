package server;

import java.net.Socket;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Calcula extends Thread {
    Comunicacao comunicacao;

    public Calcula(Socket socket) {
        comunicacao = new Comunicacao(socket);
    }

    @Override
    public void run() {
        Requisicao requisicao = (Requisicao) comunicacao.receber();

        char operador = requisicao.getOperador();
        Resposta resposta = new Resposta();
        double resultado;

        switch (operador) {
            case '+':
                resultado = requisicao.getValor1() + requisicao.getValor2();
                resposta.setValor(resultado);
                resposta.setStatus(Resposta.OK);
                break;
            case '-':
                resultado = requisicao.getValor1() - requisicao.getValor2();
                resposta.setValor(resultado);
                resposta.setStatus(Resposta.OK);
                break;
            case '*':
                resultado = requisicao.getValor1() * requisicao.getValor2();
                resposta.setValor(resultado);
                resposta.setStatus(Resposta.OK);
                break;
            case '/':
                if( requisicao.getValor2() == 0) {
                    resposta.setStatus(Resposta.DIVISAO_POR_ZERO);
                } else {
                    resultado = requisicao.getValor1() / requisicao.getValor2();
                    resposta.setValor(resultado);
                    resposta.setStatus(Resposta.OK);
                }
                break;
        
            default:
                resposta.setStatus(Resposta.OPERADOR_INVALIDO);
                break;
        }

        comunicacao.enviar(resposta);
    }

}
