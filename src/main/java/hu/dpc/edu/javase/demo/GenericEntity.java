package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public interface GenericEntity<ID> {
    ID getId();
    void setId(ID id);
}
