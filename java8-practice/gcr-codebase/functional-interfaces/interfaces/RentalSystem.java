package interfaces;
import java.util.List;

interface RentalVehicle {
    void rent();

    void returnVehicle();
}

class Car implements RentalVehicle {

    @Override
    public void rent() {
        System.out.println("Car rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car returned");
    }
}

class Bike implements RentalVehicle {

    @Override
    public void rent() {
        System.out.println("Bike rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}

class Bus implements RentalVehicle {

    @Override
    public void rent() {
        System.out.println("Bus rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus returned");
    }
}

public class RentalSystem {

    public static void main(String[] args) {

        List<RentalVehicle> vehicles = List.of(
                new Car(),
                new Bike(),
                new Bus());

        // Rent all vehicles
        vehicles.forEach(RentalVehicle::rent);

        // Return all vehicles
        vehicles.forEach(RentalVehicle::returnVehicle);
    }
}
