// Write a Program to compute the volume of Earth in km^3 and miles^3
// Hint => Volume of a Sphere is (4/3) * pi * r^3 and radius of earth is 6378 km
// O/P => The volume of earth in cubic kilometers is ____ and cubic miles is ____

public class VolumeOfEarth {

  public static void main(String[] args) {
    double radiumInKm = 6378;

    double volumeInKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiumInKm, 3);
    // 1km=0.621371 miles
    double radiumInMiles = radiumInKm * 0.621371;
    double volumeInMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiumInMiles, 3);

    System.out
        .println("The volume of earth in cubic kilometers is " + volumeInKm3 + " and cubic miles is " + volumeInMiles3);
  }
}
