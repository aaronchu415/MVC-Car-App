
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;

import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Arrays;


public class CarAppView {

    //Width and height of the window
    private final int WIDTH;
    private final int HEIGHT;


    //primary box to hold everything
    private VBox primaryBox;

    //heading text
    private Text headingOneText, headingTwoText;


    //Input fields for paramaters to create car
    private TextField CarVinInputField;
    private Label CarVinInputLabel;
    private static final String CAR_VIN_INPUT_FIELD_PROMPT_TEXT = "Vin Number";

    private TextField CarOwnerNameInputField;
    private Label CarOwnerNameLabel;
    private static final String CAR_OWNER_NAME_INPUT_PROMPT_TEXT = "Owner Name";

    private ComboBox<VehicleMakes> makeComboBox;
    private Label CarModelInputLabel;
    private static final String CAR_MODEL_INPUT_PROMPT_TEXT = "Model";

    private TextField CarDoorsInputField;
    private Label CarDoorInputLabel;
    private static final String CAR_DOOR_INPUT_PROMPT_TEXT = "Doors";


    //Buttons

    Button addButton;
    Button printAllCarInfoButton;
    Button removeAllCarButton;
    Button honkCarButton;


    //output text area
    private TextArea outputTextArea;


    private final static Font headingOneFont = Font.font("Helvetica", 35);
    private final static Font headingTwoFont = Font.font("Helvetica", 15);


    public CarAppView(int WIDTH, int HEIGHT) {

        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        //method to set up the layout.
        createLayout();

    }

    public void createLayout() {


        primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(50);
        //primaryBox.setStyle("-fx-background-color: white");
        //primaryBox.setStyle("fx-text-fill: white");

        //Set Background

        BackgroundImage myBI = new BackgroundImage(new Image("https://www.popsci.com/sites/popsci.com/files/styles/325_1x_/public/images/2018/03/senna.jpg?itok=WnqEbnyv&fc=50,50",
                WIDTH, HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        primaryBox.setBackground(new Background(myBI));

        ///////////////HeadingBox////////////////////////////////

        headingOneText = new Text("Welcome to the Car App");
        headingTwoText = new Text("Please provide details on the Cars you own!");

        headingOneText.setFont(headingOneFont);
        headingOneText.setFill(Color.WHITE);
        headingTwoText.setFont(headingTwoFont);
        headingTwoText.setFill(Color.WHEAT);

        VBox headingBox = new VBox(headingOneText, headingTwoText);
        headingBox.setAlignment(Pos.CENTER);
        headingBox.setSpacing(10);

        ////////////////BodyBox//////////////////////////////////

        // --------------Vin Input box ------------------- //
        CarVinInputField = new TextField();
        CarVinInputField.setPromptText("Please Enter: " + CAR_VIN_INPUT_FIELD_PROMPT_TEXT);
        CarVinInputField.setPrefWidth(WIDTH*.25);

        CarVinInputLabel = new Label(CAR_VIN_INPUT_FIELD_PROMPT_TEXT);
        CarVinInputLabel.setPrefWidth(WIDTH*.15);
        CarVinInputLabel.setTextFill(Color.WHITE);


        HBox vinBox = new HBox(CarVinInputLabel,CarVinInputField);
        vinBox.setPrefWidth(WIDTH);
        vinBox.setAlignment(Pos.CENTER);
        vinBox.setSpacing(5);

        // -------------- Owner Input box ------------------- //
        CarOwnerNameInputField = new TextField();
        CarOwnerNameInputField.setPromptText("Please Enter: " + CAR_OWNER_NAME_INPUT_PROMPT_TEXT);
        CarOwnerNameInputField.setPrefWidth(WIDTH*.25);

        CarOwnerNameLabel = new Label(CAR_OWNER_NAME_INPUT_PROMPT_TEXT);
        CarOwnerNameLabel.setPrefWidth(WIDTH*.15);
        CarOwnerNameLabel.setTextFill(Color.WHITE);

        HBox ownerBox = new HBox(CarOwnerNameLabel,CarOwnerNameInputField);
        ownerBox.setPrefWidth(WIDTH);
        ownerBox.setAlignment(Pos.CENTER);
        ownerBox.setSpacing(5);


        // -------------- Model Input box ------------------- //
        CarModelInputLabel = new Label(CAR_MODEL_INPUT_PROMPT_TEXT);
        CarModelInputLabel.setPrefWidth(WIDTH*.15);
        CarModelInputLabel.setTextFill(Color.WHITE);

        ObservableList<VehicleMakes> statusOptions = FXCollections.observableArrayList((Arrays.asList(VehicleMakes.values())));
        makeComboBox = new ComboBox<VehicleMakes>(statusOptions);
        makeComboBox.setValue(VehicleMakes.TOYOTA);
        makeComboBox.setPrefWidth(WIDTH*.25);

        HBox modelBox = new HBox(CarModelInputLabel,makeComboBox);
        modelBox.setPrefWidth(WIDTH);
        modelBox.setAlignment(Pos.CENTER);
        modelBox.setSpacing(5);




        // -------------- Door Input box ------------------- //
        CarDoorsInputField = new TextField();
        CarDoorsInputField.setPromptText("Please Enter: " + CAR_DOOR_INPUT_PROMPT_TEXT);
        CarDoorsInputField.setPrefWidth(WIDTH*.25);

        CarDoorInputLabel = new Label(CAR_DOOR_INPUT_PROMPT_TEXT);
        CarDoorInputLabel.setPrefWidth(WIDTH*.15);
        CarDoorInputLabel.setTextFill(Color.WHITE);

        HBox doorBox = new HBox(CarDoorInputLabel,CarDoorsInputField);
        doorBox.setPrefWidth(WIDTH);
        doorBox.setAlignment(Pos.CENTER);
        doorBox.setSpacing(5);



        //adding all the input parameter boxes into a vbox

        VBox bodyBox = new VBox(vinBox
                , ownerBox
                , modelBox
                , doorBox);

        bodyBox.setMaxWidth(WIDTH);
        bodyBox.setAlignment(Pos.CENTER);
        bodyBox.setSpacing(5);

        ////////////////BodyTwoBox//////////////////////////////////

        // --------------  Add Car button ------------------- //
        addButton = new Button("Create Car!");

        // --------------  Print All Car Button ------------------- //
        printAllCarInfoButton = new Button("Information on All Cars");

        // --------------  Remove All Car Button ------------------- //
        removeAllCarButton = new Button("Remove all Cars");

        // --------------  Honk All Car Button ------------------- //
        honkCarButton = new Button("Honk the Cars!");


        //adding all the buttons into an hbox
        HBox buttonBox = new HBox(addButton,printAllCarInfoButton,removeAllCarButton, honkCarButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setMinWidth(WIDTH);
        buttonBox.setSpacing(20);


        //adding all the hbox into a vbox
        VBox bodyTwoBox = new VBox(buttonBox);

        //bodyBox.setPrefHeight(HEIGHT * 0.33);
        bodyTwoBox.setMaxWidth(WIDTH);
        bodyTwoBox.setAlignment(Pos.CENTER);
        bodyTwoBox.setSpacing(5);

        ////////////////BodyThreeBox//////////////////////////////////

        outputTextArea = new TextArea();
        outputTextArea.setMaxWidth(WIDTH*.95);

        VBox bodyThreeBox = new VBox(outputTextArea);

        bodyThreeBox.setMaxWidth(WIDTH);
        bodyThreeBox.setAlignment(Pos.CENTER);
        bodyThreeBox.setSpacing(5);



        //adding the heading, and three body into the primaryBox

        primaryBox.getChildren().add(headingBox);
        primaryBox.getChildren().add(bodyBox);
        primaryBox.getChildren().add(bodyTwoBox);
        primaryBox.getChildren().add(bodyThreeBox);


    }

    //returns the layout (vbox)

    public Parent getParent() {
        return primaryBox;
    }


    //process button actions (handler function is sent from controller class)

    public void setAddCarButtonAction(EventHandler<ActionEvent> handler) {
        addButton.setOnAction(handler);
    }
    public void setPrintAllCarInfoButtonAction(EventHandler<ActionEvent> handler) {
        printAllCarInfoButton.setOnAction(handler);
    }
    public void setRemoveAllCarButtonAction(EventHandler<ActionEvent> handler) {
        removeAllCarButton.setOnAction(handler);
    }

    public void setHonkCarButtonAction(EventHandler<ActionEvent> handler) {
        honkCarButton.setOnAction(handler);
    }

    //change the text in the outputTextArea

    public void displayResultText(String output) {

        outputTextArea.setText(output);
    }


    //clear all inputs for the car parameters
    public void clearInputs() {
        CarVinInputField.clear();
        CarOwnerNameInputField.clear();
        CarDoorsInputField.clear();
        makeComboBox.setValue(VehicleMakes.TOYOTA);
    }



    //getters for car parameters to pass to car class

    public String getCarVin() {
        return CarVinInputField.getText();
    }

    public String getCarOwner() {
        return CarOwnerNameInputField.getText();
    }

    public String getCarDoor() {
        return CarDoorsInputField.getText();
    }

    public VehicleMakes getCarModel() {
        return makeComboBox.getValue();
    }




}