package kz.edu.nu.cs.teaching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestComposite {
    
    @Test
    public void test_1() {
        Adding x = new Adding(new Vals(3.0), new Vals(7.0));
        
        assertEquals("Composite pattern test 1", 10.0, x.getValue(), 0.01);
    }
}
