/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author IQJB
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer>map = new HashMap<>();
        map.put("egy", 1);
        map.put("ketto", 2);
        map.put("harom", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
