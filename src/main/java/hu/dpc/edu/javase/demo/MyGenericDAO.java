package hu.dpc.edu.javase.demo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author IQJB
 * @param <E>
 * @param <ID>
 */
public abstract class MyGenericDAO<E extends GenericEntity<ID>,ID> {
    
    final Class<E>clazz;
    final Map<ID,E>entities = new HashMap<>();

    public MyGenericDAO(Class<E> clazz) {
        this.clazz = clazz;
    }

    public E create(ID id) {
        try {
            final E entity = clazz.newInstance();
            entity.setId(id);
            return entity;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void persist(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        if (entities.containsKey(entity.getId())) {
            throw new EntityExistsException(clazz, entity.getId());
        }
        entities.put(entity.getId(), entity);
    }
    
    public void update(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        if (!entities.containsKey(entity.getId())) {
            throw new EntityExistsException(clazz, entity.getId());
        }
        entities.put(entity.getId(), entity);
    }
    
    public E find(ID id) {
        checkWhetherEntityExists(id);
        return entities.get(id);
    }

    private void checkWhetherEntityExists(ID id) throws EntityNotFoundException {
        if (!entities.containsKey(id)) {
            throw new EntityNotFoundException(clazz, id);
        }
    }
    
    public E remove(ID id) {
        checkWhetherEntityExists(id);
        return entities.remove(id);
    }
}
