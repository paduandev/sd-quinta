import data.GerenciaClientes;

public class App {
    public static void main(String[] args) {

        GerenciaClientes clientes = new GerenciaClientes();

        clientes.cadastrar("Carlos", 23, 1000);

        System.out.println(clientes.consultar("Carlos"));

        System.out.println(clientes.consultar("Renata"));

    }
}
