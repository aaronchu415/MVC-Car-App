public class Car extends Vehicle {

    private static int numOfCarsCreated = 0;


    public Car(String vinNum, VehicleMakes make, String model, String owner, int numOfDoors) {
        super(vinNum, make, model, owner, numOfDoors);
        numOfCarsCreated++;
    }

    public static int getNumOfCarsCreated() {
        return numOfCarsCreated;
    }

    public static void setNumOfCarsCreated(int numOfCarsCreated) {
        Car.numOfCarsCreated = numOfCarsCreated;
    }



}