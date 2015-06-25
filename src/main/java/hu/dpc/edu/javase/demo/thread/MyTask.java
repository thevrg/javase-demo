package hu.dpc.edu.javase.demo.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class MyTask implements Runnable{

    private int i;
    
    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        for (; i < 100; i++) {
            System.out.println(tn + ": i =" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
