package threads;

public class AppThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Final do main");
    }
}
