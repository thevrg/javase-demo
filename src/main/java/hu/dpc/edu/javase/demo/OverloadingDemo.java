package hu.dpc.edu.javase.demo;

import java.util.Date;

/**
 *
 * @author IQJB
 */
public class OverloadingDemo {

    private static String hello(String s, Date d) {
        System.out.println("string, date");
        return s;
    }

    private static void hello(Date d, String s) {
        System.out.println("date, string");
    }

    private static void hello(String s1, String s2) {
        System.out.println("string, string");
    }

    private static void hello(Object... args) {
        System.out.println("Object...");
    }

    private static void hello(String... args) {
        System.out.println("String...");
    }

    private static void hello(Integer a, String b) {
        System.out.println("Integer, String");
    }

    private static void hello(String a, String... b) {
        System.out.println("String, String...");
    }

    public static void main(String[] args) {
        String a;

        if (Math.random() > 0.000019999) {
            a = "xxx";
        } else {
            a = null;
        }

        String b = a;

        hello("A", new String[]{"A", "B"});

    }
}
