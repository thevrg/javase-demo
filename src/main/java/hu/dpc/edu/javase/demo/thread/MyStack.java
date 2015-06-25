package hu.dpc.edu.javase.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class MyStack {

    private int index;
    private char[] buffer = new char[10];
    private final Lock lock = new ReentrantLock();
    private Condition NOT_EMPTY = lock.newCondition();
    private Condition NOT_FULL = lock.newCondition();

    public void push(char c) {
        String tn = Thread.currentThread().getName();
        try {
            lock.lock();
            System.out.println(tn + ": push " + c);
            while (index == buffer.length) {
                try {
                    NOT_FULL.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyStack.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            buffer[index++] = c;
            NOT_EMPTY.signal();
        } finally {
            lock.unlock();
        }
    }

    public char pop() {
        String tn = Thread.currentThread().getName();
        char c;
        try {
            lock.lock();
            System.out.println(tn + ": pop");
            while (index == 0) {
                try {
                    System.out.println(tn + ": waiting...");
                    NOT_EMPTY.await();
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
            NOT_FULL.signal();
            System.out.println(tn + ": popped " + c);
        } finally {
            lock.unlock();
        }
        return c;
    }
}
