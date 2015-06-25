package hu.dpc.edu.javase.demo.thread;

/**
 *
 * @author IQJB
 */
public class Application {
    
    private static final Application INSTANCE = new Application();
    private volatile boolean timeToQuit;

    public static Application getInstance() {
        return INSTANCE;
    }

    public boolean isTimeToQuit() {
        return timeToQuit;
    }

    public void setTimeToQuit(boolean timeToQuit) {
        System.out.println("Time to quit");
        this.timeToQuit = timeToQuit;
    }
    
    public boolean sleep(long time) {
        String tn = Thread.currentThread().getName();
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            if (Application.getInstance().isTimeToQuit()) {
                System.out.println(tn + ": Quiting...");
                return true;
            }
        }
        return false;
    }
    
}
