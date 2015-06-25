/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author IQJB
 */
public class MyActionListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        System.out.println("Command: " + e.getActionCommand());
    }
    
}
