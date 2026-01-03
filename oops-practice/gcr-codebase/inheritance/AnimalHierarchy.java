
public class AnimalHierarchy {
  private String name;
  private int age;

  public AnimalHierarchy() {
    this.name = "Unknown";
    this.age = 0;
  }

  public AnimalHierarchy(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void makeSound() {

    System.out.println("Sound make by the animal");
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public static void main(String[] args) {
    AnimalHierarchy dog = new Dog("D", 3);
    AnimalHierarchy cat = new Cat("C", 2);
    AnimalHierarchy bird = new Bird("B", 1);

    dog.makeSound();
    cat.makeSound();
    bird.makeSound();
  }
}

class Dog extends AnimalHierarchy {
  public Dog(String name, int age) {
    super(name, age);
  }

  @Override
  public void makeSound() {
    System.out.println("The dog barks");
  }
}

class Cat extends AnimalHierarchy {
  public Cat(String name, int age) {
    super(name, age);
  }

  @Override
  public void makeSound() {
    System.out.println("The cat meows");
  }
}

class Bird extends AnimalHierarchy {
  public Bird(String name, int age) {
    super(name, age);
  }

  @Override
  public void makeSound() {
    System.out.println("The bird chirps");
  }
}
