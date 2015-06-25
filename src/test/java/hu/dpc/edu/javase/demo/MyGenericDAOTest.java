package hu.dpc.edu.javase.demo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IQJB
 */
public class MyGenericDAOTest {
    
    public MyGenericDAOTest() {
    }

    @Test()
    public void testCreate() {
        //given
        MyEntityDAO tested = new MyEntityDAO();
        
        //when
        MyEntity created = tested.create("alma");
        
        //then
        assertEquals("alma", created.getId());
    }

    @Test
    public void testPersist() {
        //given
        MyEntityDAO tested = new MyEntityDAO();
        MyEntity entity = new MyEntity();
        entity.setId("xxx");
        
        //when
        tested.persist(entity);
        
        //then
        assertSame(entity, tested.entities.get("xxx"));
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testFind() {
    }

    @Test
    public void testRemove() {
    }
    
    public static class MyEntity implements GenericEntity<String>{
        private String id;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void setId(String id) {
            this.id = id;
        }
        
    }

    public static class MyEntityDAO extends MyGenericDAO<MyEntity,String> {

        public MyEntityDAO() {
            super(MyEntity.class);
        }
    }
    
}
