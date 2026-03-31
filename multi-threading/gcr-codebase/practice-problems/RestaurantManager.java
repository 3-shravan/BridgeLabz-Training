class Chef extends Thread {
  private final String dish;
  private final long cookingTime;

  Chef(String name, String dish, long cookingTime) {
    super(name); // set thread name
    this.dish = dish;
    this.cookingTime = cookingTime;
  }

  @Override
  public void run() {
    System.out.println(getName() + " started preparing " + dish);
    int[] progressMarks = { 25, 50, 75, 100 };
    for (int progress : progressMarks) {
      try {
        Thread.sleep(cookingTime / 4);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      System.out.println(getName() +
          " preparing " + dish + ": " + progress + "% complete");
    }
    System.out.println(getName() + " finished preparing " + dish);

  }
}

public class RestaurantManager {
  public static void main(String[] args) throws InterruptedException {
    Chef chef1 = new Chef("Chef-1", "Pizza", 3000);
    Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
    Chef chef3 = new Chef("Chef-3", "Salad", 1000);
    Chef chef4 = new Chef("Chef-4", "Burger", 2500);

    chef1.start();
    chef2.start();
    chef3.start();
    chef4.start();

    chef1.join();
    chef2.join();
    chef3.join();
    chef4.join();

    System.out.println("Kitchen closed - All orders completed");
  }

}
