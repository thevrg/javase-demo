package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class FinalDemo {
    public static void main(final String[] args) {
        
        System.out.println("FinalDemo started...");
        Customer c = null;
        System.out.println("Customer c = null");
        System.out.println("Customer.VIP = " + Customer.VIP);
        System.out.println("Customer.DEFAULT_NAME = " + Customer.DEFAULT_NAME);
        c = new Customer(123L);
    }
}
