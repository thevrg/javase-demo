package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class MyEvilResource implements AutoCloseable {
    private String name;
    private Class<? extends RuntimeException> exType;
    
      public MyEvilResource(String name, Class<? extends RuntimeException> exType) {
        System.out.println("MyEvilResource.<init>:  " + name);
        this.name = name;
        this.exType = exType;
    }

    
    @Override
    public void close() {
        System.out.println(name + ": MyEvilResource.close()");
        try {
            throw exType.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Could not instantiate exception: ", ex);
        }
    }
}
