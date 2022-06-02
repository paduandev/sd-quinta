package singleton;

public class Highlander {
    private static Highlander instancia;

    private Highlander() {
        System.out.println("Instancia criada");
    }

    public synchronized static Highlander get() {
        if (instancia == null) {
            instancia = new Highlander();
        }
        return instancia;
    }

    public void use() {
        System.out.println("Instancia sendo usada....");
    }

}
