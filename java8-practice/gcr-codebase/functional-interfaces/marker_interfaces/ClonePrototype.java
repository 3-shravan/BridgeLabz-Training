package marker_interfaces;

class PrototypeModel implements Cloneable {
  private String name;

  PrototypeModel(String name) {
    this.name = name;
  }

  @Override
  public PrototypeModel clone() {
    try {
      return (PrototypeModel) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return "PrototypeModel: " + name;
  }
}

public class ClonePrototype {

  public static void main(String[] args) {

    PrototypeModel model = new PrototypeModel("Base Model");
    PrototypeModel cloned = model.clone();

    System.out.println(model);
    System.out.println(cloned);
  }
}
