interface MealPlan {
  String getMealType();

  int getCalories();
}

class VegetarianMeal implements MealPlan {
  @Override
  public String getMealType() {
    return "Vegetarian";
  }

  @Override
  public int getCalories() {
    return 500;
  }

}

class VeganMeal implements MealPlan {
  @Override
  public String getMealType() {
    return "Vegan";
  }

  public int getCalories() {
    return 400;
  }
}

class KetoMeal implements MealPlan {
  public String getMealType() {
    return "Keto";
  }

  public int getCalories() {
    return 2000;
  }
}

class HighProteinMeal implements MealPlan {
  public String getMealType() {
    return "High Protein";
  }

  public int getCalories() {
    return 2200;
  }
}

class Meal<T extends MealPlan> {
  private T mealPlan;

  public Meal(T mealPlan) {
    this.mealPlan = mealPlan;
  }

  public T getMealPlan() {
    return mealPlan;
  }
}

class MealPlanGenerator {
  public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
    if (meal.getCalories() < 1200 || meal.getCalories() > 2500) {
      throw new IllegalArgumentException("Calories should be in the range of 1200 to 2500");
    }
    return new Meal<>(meal);
  }
}

public class MealPlanner {

  public static void main(String[] args) {

    Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());

    Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());

    System.out.println(vegMeal.getMealPlan().getMealType() + " | Calories: " + vegMeal.getMealPlan().getCalories());

    System.out.println(ketoMeal.getMealPlan().getMealType() + " | Calories: " + ketoMeal.getMealPlan().getCalories());
  }

}
