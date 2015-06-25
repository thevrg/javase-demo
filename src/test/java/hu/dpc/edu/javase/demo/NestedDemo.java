package hu.dpc.edu.javase.demo;

import org.junit.Test;

/**
 *
 * @author IQJB
 */
public class NestedDemo {
    
    //@Test
    public void testNestedStatic() {
        Outer o1 = new Outer("o1");
        Outer.NestedStatic ns1 = new Outer.NestedStatic("ns1");
        System.out.println(ns1);
        
        String info = ns1.getInfo(o1);
        System.out.println("info: " + info);
    }
  //  @Test
    public void testInner() {
        Outer o1 = new Outer("o1");
        Outer o2 = new Outer("o2");
        Outer.Inner i1 = o1.createInner("i1");
        Outer.Inner i2 = o2.createInner("i2");
        Outer.Inner i3 = o1.new Inner("i3");
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        
    }
//    @Test
    public void testLocal() {
        Outer o1 = new Outer("o1");
        Outer o2 = new Outer("o2");
        Object l1 = o1.createLocal("l1", 123);
        Object l2 = o1.createLocal("l2", 124);
        System.out.println(l1);
        System.out.println(l2);
        
    }
    @Test
    public void testAnonymous() {
        Outer o1 = new Outer("o1");
        Outer o2 = new Outer("o2");
        Object a1 = o1.createAnonymous("a1", 123);
        Object a2 = o2.createLocal("a2", 124);
        System.out.println(a1);
        System.out.println(a2);
        
    }
}
