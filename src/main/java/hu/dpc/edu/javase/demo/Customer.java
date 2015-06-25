package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class Customer {

    private static long counter;
    public static final String VIP = "VIP";
    public static final String DEFAULT_NAME = System.getProperty("default.customer.name");
    public long id;
    private String name;

    static {
        System.out.println("Customer is loading...");
    }

    {
        id = ++counter;
    }

    public Customer() {
        name = DEFAULT_NAME;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(long id) {
        this();
        this.id = id;
    }

    {
        id++;
    }

    static {
        System.out.println("Customer is loaded...");
    }

    public String getName() {
        return name;
    }
}
