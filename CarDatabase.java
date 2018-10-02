import java.util.ArrayList;

public class CarDatabase {

    private ArrayList<Vehicle> listOfCars;


    public CarDatabase() {

        listOfCars = new ArrayList<Vehicle>();

    }

    public void addCar(Vehicle myVehicle) {

        listOfCars.add(myVehicle);

    }

    public Vehicle removeCar(int indexNum) {

        Vehicle removedVehicle = null;

        try {
            removedVehicle = listOfCars.get(indexNum);
            listOfCars.remove(indexNum);
        }
        catch (IndexOutOfBoundsException e ) {
            System.out.println(e.toString());
        }

        return removedVehicle;
    }

    //getters

    public ArrayList<Vehicle> getListOfCars() {
        return listOfCars;
    }


    //setters
    public void setListOfCars(ArrayList<Vehicle> listOfCars) {
        this.listOfCars = listOfCars;
    }


    @Override
    public String toString() {
        return "CarDatabase{" +
                ", \n \n VehicleList=" + listOfCars.toString() +
                '}';
    }

}
