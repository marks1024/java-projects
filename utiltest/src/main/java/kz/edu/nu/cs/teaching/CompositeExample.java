package kz.edu.nu.cs.teaching;

public class CompositeExample {
  public static void main(String[] args) {
    
    // (2 + 2) * (2 + (2 * 2))
    // Multiplying x = new Multiplying(new Adding(new Vals(2.0), new Vals(2.0)),
    //    new Adding(new Vals(2.0), new Multiplying(new Vals(2.0), new Vals(2.0))));
      
    Term x = new Multiplying(new Adding(new Vals(2.0), new Vals(2.0)),
        new Adding(new Vals(2.0), new Multiplying(new Vals(2.0), new Vals(2.0))));
    
    System.out.println(x.getValue());
    System.out.println(x.getDepth());
  }
}

abstract class Term {
  public abstract double getValue();
  public abstract int getDepth();
}

class Vals extends Term {
  private double myValue;

  public Vals(double m) {
    this.myValue = m;
  }

  public double getValue() {
    return myValue;
  }
  
  public int getDepth() {
      return 0;
  }
}

abstract class Opers extends Term {
  protected Term leftVal;
  protected Term rightVal;

  public Opers(Term l, Term r) {
    this.leftVal = l;
    this.rightVal = r;
  }
  
  public int getDepth() {
      return 1 + Math.max(leftVal.getDepth(), rightVal.getDepth());
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
