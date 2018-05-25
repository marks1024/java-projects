package kz.edu.nu.cs.teaching;

public class BuilderExample {
  public static void main(String[] args) {
    TicketBuilder tb = new TicketBuilder();

    Ticket t = tb.from("Astana")
        .on("March 12")
        .to("Frankfurt")
        .withClass("Economy")
        .build();

    System.out.println(t);
  }
}

class Ticket {
  private String origin;
  private String destination;
  private String date;
  private String travelClass;

  public Ticket(String orig,
      String dest,
      String date,
      String trav) {
    this.origin = orig;
    this.destination = dest;
    this.date = date;
    this.travelClass = trav;
  }

  public Ticket(TicketBuilder tb) {
    this(tb.origin,
        tb.destination,
        tb.date,
        tb.travelClass);
  }

  @Override
  public String toString() {
    return travelClass + " class ticket on " + date + " from " + origin + " to " + destination; 
  }
}

class TicketBuilder {
  String origin;
  String destination;
  String date;
  String travelClass;

  public TicketBuilder from(String f) {
    this.origin = f;
    return this;
  }

  public TicketBuilder to(String t) {
    this.destination = t;
    return this;
  }

  public TicketBuilder on(String o) {
    this.date = o;
    return this;
  }

  public TicketBuilder withClass(String c) {
    this.travelClass = c;
    return this;
  }

  public Ticket build() {
    return new Ticket(this);
  }
}
