package hu.dpc.edu.javase.demo.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author IQJB
 */
public class CharacterExchangerFilterReader extends FilterReader {

    private final char from;
    private final char to;

    public CharacterExchangerFilterReader(char from, char to, Reader in) {
        super(in);
        this.from = from;
        this.to = to;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int numberOfReadChars = super.read(cbuf, off, len);
        
        for (int i = off; i < off +  len; i++) {
            char c = cbuf[i];
            if (c == from) {
                cbuf[i] = to;
            }
        }
        
        return numberOfReadChars;
    }
    
    
    
    
}
