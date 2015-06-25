/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class FinallyDemo {

    public static int hello() {
        try {
            throw new RuntimeException("NA");
        } finally {
            try {
                System.out.println("34?");
                return 42;
            } finally {
                System.out.println("en meg erosebb vagyok");
                return 33;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("" + hello());
    }
}
