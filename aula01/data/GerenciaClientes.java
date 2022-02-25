package data;

import java.util.ArrayList;

import base.Cliente;

public class GerenciaClientes {
    private ArrayList<Cliente> listaClientes;

    public GerenciaClientes() {
        listaClientes = new ArrayList<>();
    }

    public void cadastrar(String nome, int idade, float saldo) {
        Cliente cli = new Cliente(nome, idade, saldo);

        listaClientes.add(cli);
    }

    public String consultar(String nome) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getNome().equals(nome)) {
                return cliente.toString();
            }
        }
        return "Não encontrado.";
    }

}
