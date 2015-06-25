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
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class ExceptionDemo {

    /**
     *
     * @param name
     * @return
     * @throws FileNotFoundException dffd
     * @throws UnsupportedEncodingException fdfdf
     * @throws IOException dfdf
     */
    private static String readFile(String name) throws FileNotFoundException, UnsupportedEncodingException, RuntimeException, Error {
        
//        return new Scanner("\\z").next();
        
        FileInputStream fis = null;
        try (MyEvilResource rs1 = new MyEvilResource("RS1", ArrayIndexOutOfBoundsException.class);
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(name), "UTF-8"));
                MyEvilResource rs2 = new MyEvilResource("RS2", NullPointerException.class);) {
            String line;
            StringBuilder sb = new StringBuilder();
            final String lineSeparator = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(lineSeparator);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException ex) {
            throw new ReaderException(name, "Unsupported encoding", ex);
        } catch (FileNotFoundException ex) {
            System.out.println("EX.message: " + ex.getMessage());
            throw ex;
        } catch (IOException ex) {
            throw new ReaderException(name, "Could not read file", ex);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        try {
            String file = readFile("xxx");
            System.out.println("file: " + file);
        } catch (ReaderException ex) {
            System.out.println("Reader exception: " + ex);
            System.out.println("filename: " + ex.getFileName());
            throw new RuntimeException("Reader hiba: ", ex);
        }
    }
}
