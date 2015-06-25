package hu.dpc.edu.javase.demo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author IQJB
 */
public class IODemo {
    
    private static BufferedReader getSource() throws IOException {
        return new BufferedReader(new CharacterExchangerFilterReader('>','Y',new CharacterExchangerFilterReader('<','X',Files.newBufferedReader(Paths.get("pom.xml"), Charset.forName("UTF-8")))));
    }
            
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (InputStream in = new FileInputStream("pom.xml"); 
                OutputStream out = new FileOutputStream("pom-copy.xml")) {
            
            byte[] buffer = new byte[8192];
            int numOfBytesRead;
            
            while((numOfBytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numOfBytesRead);
            }
        }

        File file = new File("pom.xml");
        System.out.println("file.isDir: " + file.isDirectory());
        String canonicalPath = file.getCanonicalPath();
        System.out.println("canonical: " + canonicalPath);
        
        
        
        try (BufferedReader in = getSource()) {
            String line;
            
            while ((line = in.readLine()) != null) {
                System.out.println("line: " + line);
            }
        }
    }
}
