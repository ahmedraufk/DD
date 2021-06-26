package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

public class InitialConfigurationScreen extends Application {

    private Scene start;
    private Scene intro;
    private Scene game;
    protected String name;
    protected Difficulty level;
    protected Weapon weaponType;

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {

        introScreen(primaryStage);

        primaryStage.setResizable(false);
        primaryStage.setScene(intro);
        primaryStage.setTitle("Dungeon Crawler");
        primaryStage.show();

    }

    /**
     * Creates start screen.
     * @param stage the stage passed in.
     */
    private void startScreen(Stage stage) {

        //creating the starting screen.
        VBox box = new VBox(75);

        Text welcomeText = new Text("Please select the following:");

        welcomeText.setFont(new Font(25));

        ComboBox<Difficulty> difficulty = new ComboBox<Difficulty>();

        difficulty.setPromptText("Select Difficulty");

        difficulty.getItems().setAll(Difficulty.values());

        ComboBox<Weapon> weapon = new ComboBox<Weapon>();

        weapon.setPromptText("Select Weapon");

        weapon.getItems().setAll(Weapon.values());

        TextField nameField = new TextField();

        nameField.setMaxWidth(150);

        nameField.setPromptText("Name:");

        StackPane pane = new StackPane();

        Button startbtn = new Button("Start");

        startbtn.setStyle("-fx-font-size:20");

        startbtn.setMaxWidth(150);

        box.getChildren().addAll(welcomeText, difficulty, weapon, nameField, startbtn);

        box.setAlignment(Pos.CENTER);

        start = new Scene(box, 525, 525);

        //lambda expression for start button
        startbtn.setOnAction(e -> {

            //shows alert if either the drop down menu item is not selected or name is not entered.
            if (nameField.getText().isEmpty()
                    || nameField.getText().trim().isEmpty()
                    || difficulty.getSelectionModel().isEmpty()
                    || weapon.getSelectionModel().isEmpty()) {

                Alert error = new Alert(Alert.AlertType.ERROR, "Please enter your name "
                        + "AND/OR one of the difficulties "
                        + "AND/OR one of the weapons to continue.");

                error.setTitle("Error Detected");

                error.showAndWait();

            } else {

                name = nameField.getText();

                level = difficulty.getValue();

                weaponType = weapon.getValue();

                stage.setScene(game);

            }
        });
    }
    private void introScreen(Stage stage){

        //Create the intro Screen
        VBox box = new VBox(75);
        Text introText = new Text("Welcome to Dungeons and Debuggers! Press Start Game to continue");

        Button introBtn = new Button("Start");

        introBtn.setStyle("-fx-font-size:20");

        introBtn.setMaxWidth(150);
        box.getChildren().addAll(introText,introBtn);

        intro = new Scene(box, 525, 525);
        box.setAlignment(Pos.CENTER);

        //Move to start screen
        introBtn.setOnMouseClicked(e -> {
            startScreen(stage);
            stage.setScene(start);
        });




    }
    private void gameScreen(Stage stage){

    }


}
