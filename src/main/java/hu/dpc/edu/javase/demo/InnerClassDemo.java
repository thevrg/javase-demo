/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author IQJB
 */
public class InnerClassDemo {
    private JFrame frame = new JFrame("Hello world!");
    
    private JButton ok = new JButton("OK");

    public InnerClassDemo(final String msg) {
        frame.getContentPane().add(ok);
        
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("ok was pressed, msg = " + msg);
            }
        });
        
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ok.setBackground(Color.RED);
            }
        });
        
        ok.addActionListener(new MyActionListener());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new InnerClassDemo("Hello");
    }
    
    
}
