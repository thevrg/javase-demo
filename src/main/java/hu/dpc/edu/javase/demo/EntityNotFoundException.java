package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class EntityNotFoundException extends RuntimeException{
    
    private final Class<?> type;
    private final Object id;

    public EntityNotFoundException(Class<?> type, Object id) {
        super(createMessage(type, id));
        this.type = type;
        this.id = id;
    }
    
    private static String createMessage(Class<?> type, Object id) {
        return type.getSimpleName() + " not found with id " + id;
    }

}
