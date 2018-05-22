package kz.edu.nu.cs.teaching;

public class DecoratorExample {
	public static void main(String[] args) {
		TextComponent tx = new TextBase("The Text!");
		System.out.println(tx.getClass().toString());
		System.out.println(tx.produceText());

		tx = new DashBorderDecorator(tx);
		System.out.println(tx.getClass().toString());
		System.out.println(tx.produceText()); 
		
		tx = new CapitalDecorator(tx);
	    System.out.println(tx.getClass().toString());
	    System.out.println(tx.produceText());
	}
}

abstract class TextComponent {
	abstract public String produceText();
}

abstract class TextDecorator extends TextComponent {
	protected TextComponent next;

	public TextDecorator(TextComponent t) {
		this.next = t;
	}

	public String produceText() {
		return this.next.produceText();
	}
}

class TextBase extends TextComponent {
	private String s;

	public TextBase(String s) {
		this.s = s;
	}

	@Override
	public String produceText() {
		return s;
	}

}

class DashBorderDecorator extends TextDecorator {

	public DashBorderDecorator(TextComponent t) {
		super(t);
	}

	@Override
	public String produceText() {
		return "--- " + super.produceText() + " ---";
	}
}

class CapitalDecorator extends TextDecorator {

	public CapitalDecorator(TextComponent t) {
		super(t);
	}

	@Override
	public String produceText() {
		return super.produceText().toUpperCase();
	}
}
