package hu.dpc.edu.javase.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author IQJB
 */
public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallableTask task1 = new MyCallableTask("Task1", 3000L);
        MyCallableTask task2 = new MyCallableTask("Task2", 5000L);
        
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> task1Future = es.submit(task1);
        Future<String> task2Future = es.submit(task2);
        es.shutdown();
        System.out.println("submitted tasks");
        
        System.out.println("cancelling task1");
        task2Future.cancel(true);
        
        System.out.println("task1Future.isDone(): " + task1Future.isDone());
        System.out.println("task2Future.isDone(): " + task2Future.isDone());

        System.out.println("task1 result is: " + task1Future.get());
        System.out.println("task2 result is: " + task2Future.get());
        
        
    }
}
