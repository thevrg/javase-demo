package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class ReaderException extends RuntimeException {

    public ReaderException(String fileName) {
        this.fileName = fileName;
    }

    public ReaderException(String fileName, String message) {
        super(message);
        this.fileName = fileName;
    }

    public ReaderException(String fileName, String message, Throwable cause) {
        super(message, cause);
        this.fileName = fileName;
    }

    public ReaderException(String fileName, Throwable cause) {
        super(cause);
        this.fileName = fileName;
    }

    public ReaderException(String fileName, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.fileName = fileName;
    }

    private final String fileName;

    public String getFileName() {
        return fileName;
    }
}
