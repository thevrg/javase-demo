package hu.dpc.edu.javase.demo;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author IQJB
 */
public class CollectionDemo {
    public static void main(String[] args) {
        SortedSet<MyPoint> c = new TreeSet<>(new MyPointComparator());
        System.out.println("add: " + c.add(new MyPoint(11, 20)));
        System.out.println("add: " + c.add(new MyPoint(11, 21)));
        System.out.println("add: " + c.add(new MyPoint(14, 22)));
        System.out.println("add: " + c.add(new MyPoint(10, 20)));
        System.out.println("add: " + c.add(new MyPoint(10, 20)));
        
        System.out.println("c: " + c);
        
        SortedSet headSet = c.headSet(new MyPoint(12, 22));
        
        System.out.println("headSet: " +  headSet);
        
        
        c.add(new MyPoint(0, 0));
        
        System.out.println("headSet: " +  headSet);
        
//        Collections.sort(c, new MyPointComparator());
//        
//        System.out.println("c: " + c);
    }
}
