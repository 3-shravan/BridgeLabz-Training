import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {

    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}

class DIContainer {

    public static <T> T createObject(Class<T> clazz) {
        try {
            // Create main object
            T object = clazz.getDeclaredConstructor().newInstance();

            // Scan fields
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {

                    // Create dependency
                    Class<?> dependencyType = field.getType();
                    Object dependency = dependencyType.getDeclaredConstructor().newInstance();

                    // Inject dependency
                    field.setAccessible(true);
                    field.set(object, dependency);
                }
            }
            return object;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class DependencyInjectionDemo {

    public static void main(String[] args) {

        Car car = DIContainer.createObject(Car.class);
        car.drive();
    }
}
