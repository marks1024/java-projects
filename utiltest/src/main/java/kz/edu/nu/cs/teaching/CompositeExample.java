package kz.edu.nu.cs.teaching;

public class CompositeExample {
  public static void main(String[] args) {
    
    // (2 + 2) * (2 + (2 * 2))
    // Multiplying x = new Multiplying(new Adding(new Vals(2.0), new Vals(2.0)),
    //    new Adding(new Vals(2.0), new Multiplying(new Vals(2.0), new Vals(2.0))));
    
    Adding x = new Adding(new Vals(3.0), new Vals(7.0));
    
    System.out.println(x.getValue());
  }
}

abstract class Term {
  public abstract double getValue();
}

class Vals extends Term {
  private double myValue;

  public Vals(double m) {
    this.myValue = m;
  }

  public double getValue() {
    return myValue;
  }
}

abstract class Opers extends Term {
  protected Term leftVal;
  protected Term rightVal;

  public Opers(Term l, Term r) {
    this.leftVal = l;
    this.rightVal = r;
  }
}

class Adding extends Opers {
  public Adding(Term l, Term r) {
    super(l, r);
  }

  @Override
  public double getValue() {
    return this.leftVal.getValue() + this.rightVal.getValue();
  }
}

class Multiplying extends Opers {
  public Multiplying(Term l, Term r) {
    super(l, r);
  }

  @Override
  public double getValue() {
    return this.leftVal.getValue() * this.rightVal.getValue();
  }
}
