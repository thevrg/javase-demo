package hu.dpc.edu.javase.demo.thread;

/**
 *
 * @author IQJB
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        
        System.out.println("isAlive: "  + t1.isAlive());
        t1.join();
        t1.start();
        t1.join();
        System.out.println("isAlive: "  + t1.isAlive());
        t2.start();
        System.out.println("t1, t2 started");
        System.out.println("main ends...");
    }
}
