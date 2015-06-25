/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class ArraysDemo {
    public static void main(String[] args) {
        String[] strings = {"111","Peter","PPP", "AAAA"};
        
        List<String> list = Arrays.asList(strings);
        
        System.out.println("list: " +  list);
        list.set(1,"Valami");
        
        System.out.println(Arrays.toString(strings));
    }
}
