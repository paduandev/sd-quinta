package singleton;

public class Apphighlander {
    public static void main(String[] args) {
        Highlander h1 = Highlander.get();
        Highlander h2 = Highlander.get();
        Highlander h3 = Highlander.get();
        if (h1 == h2 && h2 == h3) {
            System.out.println("Mesmo objeto");
        }
        h1.use();
    }
}
