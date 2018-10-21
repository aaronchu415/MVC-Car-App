import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class CarAppController extends Application {
    private CarDatabase parkinglotModel;
    private CarAppView applicationGUI;

    private static final int WIDTH = 800, HEIGHT = 600;


    public CarAppController() {

        parkinglotModel = new CarDatabase(); // the model
        applicationGUI = new CarAppView(WIDTH,HEIGHT); // the view

        //hook up buttons to action handlers below
        applicationGUI.setMakeComboBoxOnAction(this::processComboBoxOption);
        applicationGUI.setAddCarButtonAction(this::processAddCar);
        applicationGUI.setPrintAllCarInfoButtonAction(this::processPrintAll);
        applicationGUI.setRemoveAllCarButtonAction(this::processRemoveAll);
        applicationGUI.setHonkCarButtonAction(this::processHonkCar);

    }

    // act on the combo box selection
    private void processComboBoxOption(ActionEvent event){}

    private void processAddCar(ActionEvent event) {

        //write method to add a car object to car database
        //if user did not enter correct info, print error message
        //String vinNum, VehicleMakes make, String model, String owner, int numOfDoors
        
        try {
        	String vin        = applicationGUI.getCarVin();
            VehicleMakes make = applicationGUI.getCarModel();
            String owener     = applicationGUI.getCarOwner();
            int doorNum       = Integer.parseInt(applicationGUI.getCarDoor());
        	parkinglotModel.addCar(new Car(vin, make, "", owener, doorNum));
        	applicationGUI.clearInputs();
        } catch (IllegalArgumentException e) {
        	applicationGUI.showError("- Vin must contain letters or numbers\n- Name must have only letters\n-"
        			+ " Car must have between 2 and 6 doors");
        } finally {
        	applicationGUI.setTextAreaText(parkinglotModel.toString());
        }
    }


    private void processPrintAll(ActionEvent event) {

        //Write method to print all car info to user.
        //If no car info, print no car
        applicationGUI.setTextAreaText(parkinglotModel.toString());
    }

    private void processRemoveAll(ActionEvent event) {

        //write method to remove all car from car database
        // simple instantiate a new CarDataBase object assign to this variable
        // will clear the list.
        parkinglotModel = new CarDatabase();
    }

    private void processHonkCar(ActionEvent event) {
        //write method to honk all cars
        //if no car than print no car
        StringBuilder output = new StringBuilder();

       for(Vehicle c : parkinglotModel.getListOfCars()){
           output.append("Your " + c.getMake()+ " says: " + c.HonkHorn() + "\n");
       }
       applicationGUI.setTextAreaText(output.toString());
    }




    @Override
    public void start(Stage primaryStage) throws Exception {

        CarAppController controller = new CarAppController();

        Scene scene = new Scene(controller.applicationGUI.getParent(), WIDTH, HEIGHT, Color.TRANSPARENT);
        primaryStage.setTitle("Car App: Create and Track Your Cars!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
