package hu.dpc.edu.javase.demo;

import java.util.Comparator;

/**
 *
 * @author IQJB
 */
public class MyPointComparator implements Comparator<MyPoint>{

    @Override
    public int compare(MyPoint o1, MyPoint o2) {
        return o1.getY() - o2.getY();
    }
    
}
