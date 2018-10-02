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
        applicationGUI.setAddCarButtonAction(this::processAddCar);
        applicationGUI.setPrintAllCarInfoButtonAction(this::processPrintAll);
        applicationGUI.setRemoveAllCarButtonAction(this::processRemoveAll);
        applicationGUI.setHonkCarButtonAction(this::processHonkCar);

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

    private void processPrintAll(ActionEvent event) {

        //Write method to print all car info to user.
        //If no car info, print no car
        System.out.println("testing123");
    }

    private void processRemoveAll(ActionEvent event) {

        //write method to remove all car from car database
        System.out.println("testing123");
    }

    private void processHonkCar(ActionEvent event) {

        //write method to honk all cars
        //if no car than print no car
        System.out.println("testing123");
    }

    private void processAddCar(ActionEvent event) {

        //write method to add a car object to car database
        //if user did not enter correct info, print error message
        System.out.println("testing123");
    }

}
