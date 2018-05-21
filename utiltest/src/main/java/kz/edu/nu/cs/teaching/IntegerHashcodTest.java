package kz.edu.nu.cs.teaching;

import java.util.ArrayList;
import java.util.List;

public class IntegerHashcodTest {
    
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(25);
        a.add(20);
        a.add(15);
        a.add(10);
        a.add(5);
        
        for (Integer i : a) {
        System.out.println(i.hashCode() % 20);
        }
    }
}
