package kz.edu.nu.cs.teaching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursiveDescentParserExample {
    StreamTokenizer st;
    int nestLevel = 0;
    
    public static void main(String[] args) throws IOException {
        
        Reader r = null;
        try {
            r = new BufferedReader(new FileReader("sampledefinition.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        RecursiveDescentParserExample parser = new RecursiveDescentParserExample();
        
        parser.st = new StreamTokenizer(r);
        parser.st.nextToken();
        System.out.println(parser.statement());
        
    }
    
    public boolean val() throws IOException {
        if (this.st.ttype == StreamTokenizer.TT_NUMBER) {
            System.out.println(this.st.nval);
            this.st.nextToken();
            return true;
        }
        
        if (this.st.ttype == StreamTokenizer.TT_WORD) {
            System.out.println(this.st.sval);
            this.st.nextToken();
            return true;
        }
        
        if (arr()) {
            return true;
        }
        
        return false;
    }
    
    public boolean arr() throws IOException {
        if (terminal(40)) {
            nestLevel += 1;
            if (val()) {
                while (terminal(44)) {
                    if (val()) {
                        //
                    } else {
                        return false;
                    }
                }
            }
            
            if (terminal(41)) {
                nestLevel -= 1;
                return true;
            }
        }
        
        return false;
    }
    
    public boolean statement() throws IOException {
        if (arr() || val()) {
            if (terminal(59)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean terminal(int i) throws IOException {
        if (this.st.ttype == i) {
            String temp = Character.toString((char) i);
            temp = nestLevel + temp;
            System.out.println(temp);
            this.st.nextToken();
            return true;
        }
        
        return false;
    }
}
