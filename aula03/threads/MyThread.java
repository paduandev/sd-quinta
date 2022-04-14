package threads;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }
    
    @Override
    public void run() { // equivale ao 'main'
        System.out.println("Inicio da thread " + getName());

        try {
            sleep(2000); // 'dorme' por 2 segundos
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final da thread " + getName());
    }
    
}
