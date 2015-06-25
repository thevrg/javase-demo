package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class EntityExistsException extends RuntimeException{
    
    private final Class<?> type;
    private final Object id;

    public EntityExistsException(Class<?> type, Object id) {
        super(createMessage(type, id));
        this.type = type;
        this.id = id;
    }
    
    private static String createMessage(Class<?> type, Object id) {
        return type.getSimpleName() + " already exists with id " + id;
    }

}
