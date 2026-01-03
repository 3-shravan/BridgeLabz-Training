public class Person2 {
  private String name;
  private int id;

  Person2(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static void main(String[] args) {
    Worker chef = new Chef("Alice", 101);
    Worker waiter = new Waiter("Bob", 102);

    chef.performDuties();
    waiter.performDuties();

  }

}

interface Worker {
  void performDuties();
}

class Chef extends Person2 implements Worker {

  Chef(String name, int id) {
    super(name, id);
  }

  @Override
  public void performDuties() {
    System.out.println("Preparing meals");
  }
}

class Waiter extends Person2 implements Worker {

  Waiter(String name, int id) {
    super(name, id);
  }

  @Override
  public void performDuties() {
    System.out.println("Serving customers");
  }
}