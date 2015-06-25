package hu.dpc.edu.javase.demo.annot;

/**
 *
 * @author IQJB
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        MySecurityProxyFactory fact = new MySecurityProxyFactory();
        CustomerServiceImpl target = new CustomerServiceImpl();
        CustomerService proxy = fact.createSecurityProxy(CustomerService.class, target);

        proxy.addCustomer(new Customer(1222L, "Bela"));
        proxy.findCustomer(1111L);
        proxy.deleteCustomer(1111L);
    }
}
