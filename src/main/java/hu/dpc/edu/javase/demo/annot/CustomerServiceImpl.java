package hu.dpc.edu.javase.demo.annot;

/**
 *
 * @author IQJB
 */
public class CustomerServiceImpl implements CustomerService {

    @RolesAllowed(Role.ADMIN)
    @RolesAllowed(Role.USER)
    @java.lang.Override
    public Long addCustomer(Customer customer) {
        return 12L;
    }

    @RolesAllowed(Role.ADMIN)
    @Override
    public Customer deleteCustomer(Long id) {
        return new Customer(id);
    }

    @Override
    public Customer findCustomer(Long id) {
        return new Customer(id);
    }

}
