package kz.edu.nu.cs.teaching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTests {
    
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[abc]+");
        pattern = Pattern.compile("/[a-z]+/([0-9]+)");
        pattern = Pattern.compile("^beginning[abc]+");
        Matcher m;
//        pattern = Pattern.compile("hello");
//        Matcher m = pattern.matcher("Can you say hello?");
//        
//        if (m.find()) {
//            System.out.println("From " + 
//                             m.start() + 
//                                " to " + 
//                                m.end());
//        }
//        
//        System.out.println(m.matches());
//        
//        pattern = Pattern.compile("[0-9]*[a-z]?[0-9]*");
//        m = pattern.matcher("11111a2222");
//        System.out.println(m.matches());
        
        
        m = pattern.matcher("3end");
        m.matches();
        System.out.println(m.matches());
        // System.out.println(m.group(1));
        
        // System.out.println(m.group(2));
        
        
        // pattern = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{2}");
        // Matcher m = pattern.matcher("10/11/12");
        
        // System.out.println(m.matches());
        
//        while(m.find()) {
//            System.out.println(m.start() + " " + m.end());
//        }
    }

}
