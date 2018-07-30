package kz.edu.nu.cs.teaching;

public class Person {
  String name;
  String address;
  int age;

  public String getName() { return name.toUpperCase(); }
  public int getAge() { return age; }
  public String getDescription() {
    return getName() + " " + address;
  }
}
