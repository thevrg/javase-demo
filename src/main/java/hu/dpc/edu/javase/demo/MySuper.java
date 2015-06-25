package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class MySuper {
    private long id;

    public MySuper(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "MySuper{" + "id=" + id + '}';
    }
    
}
