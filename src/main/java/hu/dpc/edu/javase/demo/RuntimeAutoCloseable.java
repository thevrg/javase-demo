package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public interface RuntimeAutoCloseable extends AutoCloseable {

    @Override
    void close();
}
