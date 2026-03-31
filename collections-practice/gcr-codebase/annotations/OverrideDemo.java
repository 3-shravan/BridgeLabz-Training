class Animal {

  public void makeSound() {
    System.out.println("The animal makes a sound");
  }
}

class Dog extends Animal {

  @Override
  public void makeSound() {
    System.out.println("The dog barks");
  }
}

public class OverrideDemo {

  public static void main(String[] args) {

    Dog dog = new Dog();
    dog.makeSound();
  }
}
