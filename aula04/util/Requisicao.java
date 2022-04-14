package util;

import java.io.Serializable;

public class Requisicao implements Serializable {
    private double valor1, valor2;
    private char operador;

    public Requisicao(double valor1, double valor2, char operador) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.operador = operador;
    }

    public char getOperador() {
        return operador;
    }

    public double getValor1() {
        return valor1;
    }

    public double getValor2() {
        return valor2;
    }
    
}