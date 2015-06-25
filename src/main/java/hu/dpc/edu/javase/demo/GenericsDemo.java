package hu.dpc.edu.javase.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class GenericsDemo {
    public static void main(String[] args) {
        ArrayList<Manager>lm = new ArrayList<Manager>();
        Manager m1 = new Manager();
        lm.add(m1);
        lm.add(new Manager());
        
        Employee[] array = lm.toArray(new Employee[0]);
        
        
        System.out.println("array.length: " + array.length);
        
        List<? extends Employee> le = lm;

        //le.add(null);
        
        Employee get = le.get(0);
        
        le.remove(m1);

        System.out.println(lm);
        
        List<? super Manager>lsm = new ArrayList<Object>();
        
        lsm.add(new Manager());
        
        Object value = lsm.get(0);
        
        //String s = cast(value);
        
        String[] sarr = {"ABC","DEF"};
        Integer[] iarr = {1,34};
        
        String first = getFirst(sarr);
        System.out.println("first: " + first);
        
        Integer first2 = getFirst(iarr);
        
        System.out.println("first2: " + first2);
    
        EmployeeDAO dao = new EmployeeDAO();
        
        
    }
    
    public static <T> T cast(Object object) {
        return (T) object;
    }
    
    public static <T> T getFirst(T[] array) {
        return array[0];
    }
    
    public static <T> void setFirst(T[] array, T element) {
        array[0] = element;
    }
    
//    public static <T> T[] createArray(T element) {
//        return new T[] {element};
//    }
//    
    private double calcSumOfSalaries(Iterable<? extends Employee> employees) {
        double sum = 0;
        for (Employee emp : employees) {
            sum += emp.getSalary();
        }
        return sum;
    }
    
    
    
}
