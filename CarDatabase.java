import java.util.ArrayList;

public class CarDatabase {

    private ArrayList<Vehicle> listOfCars;


    public CarDatabase() {

        listOfCars = new ArrayList<>();

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


    // wenhao modified this method, so that the format of the output will look nicer.
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 1; i <= listOfCars.size(); i++){
            Vehicle car = listOfCars.get(i-1);
            str.append(i + ": "+ "Owner " + car.getOwner()
                       + " , " + "Car Vin " + car.getVinNum()
                       + " , " + "Car Make " + car.getMake().toString()
                       + " , " + "Car doors " + car.getNumOfDoors() + "\n");
        }
        return str.toString();
    }

}