package kz.edu.nu.cs.teaching;

import org.apache.commons.text.WordUtils;

public class StrategyExample {
	public static void main(String[] args) {
		String s = "The Sages say truly " + 
				"That two animals are in this forest: " + 
				"One glorious, beautiful, and swift, " + 
				"A great and strong deer; " + 
				"The other an unicorn. ";
				
		MyText text = new MyText(s, new SimpleBreakBehavior());
		System.out.println(text.makeLineBreaks());
		
		System.out.println("\n~~~~~~ Changing Line Break Behavior\n");
		text.setB(new NoBreakBehavior());
		System.out.println(text.makeLineBreaks());
	}
}

interface BreakBehavior {
	public String linebreak(String s);
}

class MyText {
    private String buff;
    private BreakBehavior b;

    public MyText(String buff, BreakBehavior b) {
        this.buff = buff;
        this.b = b;
    }

    public String makeLineBreaks() {
        return b.linebreak(buff);
    }

    public void setB(BreakBehavior b) {
        this.b = b;
    }
}

class SimpleBreakBehavior implements BreakBehavior {
    @Override
    public String linebreak(String s) {
        return WordUtils.wrap(s, 60);
    }
}

class NoBreakBehavior implements BreakBehavior {
    @Override
    public String linebreak(String s) {
        return s;
    }
}