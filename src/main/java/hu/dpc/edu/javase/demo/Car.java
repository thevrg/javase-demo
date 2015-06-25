package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class Car {
    private static long carCount;
    private long id = ++carCount;
    private String name;
    private String type;

    public static long getCarCount() {
        return carCount;
    }

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", type=" + type + ", carcount: " + getCarCount() +  '}';
    }


    
    

}
