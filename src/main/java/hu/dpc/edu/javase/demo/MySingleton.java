package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class MySingleton {
    
    static {
        
    }
    
    private static class SingletonHolder {
        private static final MySingleton INSTANCE = new MySingleton();
        
        static {
            
        }
    }
    
    public static MySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
