package kz.edu.nu.cs.util.utiltest;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataUtils {
    
    /**
     * Read a file to a single string.  
     * 
     * @param pathstring : String
     * @return res : String
     */
    public static String readFileToString(String pathstring) {
        try {
            BufferedReader bufr = new BufferedReader(new FileReader(pathstring));
            StringBuilder sb = new StringBuilder();
            String line = new String();
            while((line = bufr.readLine()) != null) {
                sb.append(line);
            }
            bufr.close();
            
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
}
