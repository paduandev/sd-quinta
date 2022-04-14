package util;

import java.io.Serializable;

public class Resposta implements Serializable {
    public static final int OK = 0;
    public static final int OPERADOR_INVALIDO = 1;
    public static final int DIVISAO_POR_ZERO = 2;
    private double valor;
    private int status;
    
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
}
