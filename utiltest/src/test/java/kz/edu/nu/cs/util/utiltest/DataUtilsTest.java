package kz.edu.nu.cs.util.utiltest;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilsTest {

    @Test
    public void reader_test() {
        String p = "./test-file.txt";
        String res = DataUtils.readFileToString(p);
        String[] a = res.split(" ");
        
        assertTrue("First word matches", "This".equals(a[0]));
        assertTrue("Second word matches", "is".equals(a[1]));
    }

}
