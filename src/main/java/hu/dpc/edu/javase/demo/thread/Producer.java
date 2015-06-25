package hu.dpc.edu.javase.demo.thread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IQJB
 */
public class Producer implements Runnable {

    private MyStack stack;
    private Random random = new Random();

    public Producer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        for (int i = 0; i < 50; i++) {
            if (Application.getInstance().isTimeToQuit()) {
                System.out.println(tn + ": Quiting...");
                return;
            }
            char c = (char) ('A' + random.nextInt('Z' - 'A'));
//            System.out.println(tn + ": Pushing " + c);
            stack.push(c);
            if (Application.getInstance().sleep(random.nextInt(100))) {
                return;
            }
        }
    }


}
