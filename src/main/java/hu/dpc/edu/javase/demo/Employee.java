package hu.dpc.edu.javase.demo;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author IQJB
 */
public class Employee implements GenericEntity<Long>{

    private static final AtomicLong counter = new AtomicLong();
    private Long id = counter.incrementAndGet();
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
