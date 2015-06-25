/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author IQJB
 */
public class TryWithResourcesDemo {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception {
        try {
            try (MyEvilResource rs1 = new MyEvilResource("RS1", ArrayIndexOutOfBoundsException.class);
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("xxx"), "UTF-8"));
                    MyEvilResource rs2 = new MyEvilResource("RS2", NullPointerException.class);
                    MyEvilResource rs3 = new MyEvilResource("RS3", ArithmeticException.class)) {
                System.out.println("hello");
            }
        } catch (RuntimeException ex) {
            ex.addSuppressed(new Exception("hello"));
            System.out.println("ex: " + ex);
            Throwable[] suppressed = ex.getSuppressed();
            for (Throwable supp : suppressed) {
                System.out.println("Found supp: " + supp);
            }
            
            ex.printStackTrace();
        }

    }
}
