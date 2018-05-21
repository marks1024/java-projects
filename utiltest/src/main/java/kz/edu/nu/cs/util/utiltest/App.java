package kz.edu.nu.cs.util.utiltest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static int wordcount(String s) {
        return s.split(" ").length;
    }
}
