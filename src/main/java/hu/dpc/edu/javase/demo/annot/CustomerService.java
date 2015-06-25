package hu.dpc.edu.javase.demo.annot;

/**
 *
 * @author IQJB
 */
public interface CustomerService {
    public Long addCustomer(Customer customer);
    public Customer deleteCustomer(Long id);
    public Customer findCustomer(Long id);
}
