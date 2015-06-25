package hu.dpc.edu.javase.demo.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class MyStack {

    private int index;
    private char[] buffer = new char[10];
    private final Object lock = new Object();

    public void push(char c) {
        String tn = Thread.currentThread().getName();
        synchronized (lock) {
            System.out.println(tn + ": push " + c);
            buffer[index++] = c;
            lock.notify();
        }
    }

    public char pop() {
        String tn = Thread.currentThread().getName();
        char c;
        synchronized (lock) {
            System.out.println(tn + ": pop");
            while (index == 0) {
                try {
                    System.out.println(tn + ": waiting...");
                    lock.wait();
                    if (index == 0) {
                        System.out.println(tn + ": VAKLARMA!!!!!!!!!!!!!!!!!!!");
                    }
                } catch (InterruptedException ex) {
                    if (Application.getInstance().isTimeToQuit()) {
                        System.out.println(tn + ": Quiting...");
                        throw new IllegalStateException("Stack is empty");
                    }
                }
            }
            c = buffer[--index];
            System.out.println(tn + ": popped " + c);
        }
        return c;
    }
}
