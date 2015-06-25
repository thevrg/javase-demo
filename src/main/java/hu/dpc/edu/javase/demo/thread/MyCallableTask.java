package hu.dpc.edu.javase.demo.thread;

import java.util.concurrent.Callable;

/**
 *
 * @author IQJB
 */
public class MyCallableTask implements Callable<String> {

    private String response;
    private long sleep;

    public MyCallableTask(String response, long sleep) {
        this.response = response;
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call: " + response);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            System.out.println("HAHA (cancelled?)");
        }
//        if (Thread.interrupted()) {
//            
//        }
        System.out.println(response + " is finished");
        return "Call result is: " + response;
    }

}
