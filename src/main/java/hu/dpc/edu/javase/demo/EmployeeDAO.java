package hu.dpc.edu.javase.demo;

import hu.dpc.edu.javase.demo.annot.Role;
import hu.dpc.edu.javase.demo.annot.RolesAllowed;

/**
 *
 * @author IQJB
 */
public class EmployeeDAO extends MyGenericDAO<Employee, Long> {

    public EmployeeDAO() {
        super(Employee.class);
    }
    
    @RolesAllowed(value = {Role.ADMIN, Role.MANAGER}, displayName = "sdfsdf")
    public double getSalaryById(Long id) {
        return find(id).getSalary();
    }

}
