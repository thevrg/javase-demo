package hu.dpc.edu.javase.demo.thread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class Consumer implements Runnable {

    private MyStack stack;
    private Random random = new Random();

    public Consumer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        int i = 0;
        while (i < 50) {
            if (Application.getInstance().isTimeToQuit()) {
                System.out.println(tn + ": Quiting...");
                return;
            }
            try {
                char popped = stack.pop();
//                System.out.println(tn + ": Popped " + popped);
                i++;
            } catch (IllegalStateException ex) {
                System.out.println(tn + ": Stack is empty :( ");
            }
            if (Application.getInstance().sleep(random.nextInt(100))) {
                return;
            }
        }
    }

}
