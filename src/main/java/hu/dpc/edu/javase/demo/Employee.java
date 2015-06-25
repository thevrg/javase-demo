package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class Employee implements GenericEntity<Long>{

    private Long id;
    private double salary;
    
    public double getSalary() {
        return salary;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
}
