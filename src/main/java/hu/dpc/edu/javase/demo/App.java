package hu.dpc.edu.javase.demo;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * dfgdfgd
     *
     * @param args dferg
     */
    public static void main(String[] args) {
        int szam = 33;
        hello(szam);
        System.out.println(szam);
        
        Car c = new Car("egyik");
        changeRef(c);
        System.out.println(c);
        changeObjectState(c);
        System.out.println(c);
    }

    public static void hello(int szam) {
        szam = 23;
    }
    public static void changeRef(Car c) {
        final Car c2 = new Car("masik");
        c = c2;
    }
    public static void changeObjectState(Car c) {
        c.setName("harmadik");
    }
}
