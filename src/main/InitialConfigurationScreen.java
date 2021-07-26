package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.Timer;


public class InitialConfigurationScreen extends Application {

    private static int moneyAmount;
    private static Stage primaryStage;
    private static Scene intro;
    private Scene start;
    private Scene game;
    protected String name;
    protected Difficulty level;
    protected Weapon weaponType;
    private static Player mainPlayer = new Player(100,5);
    private static Timer timer = new Timer();



    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        mainPlayer.setPlayerHealth(100);
        mainPlayer.setDefeated(0);
        mainPlayer.setDamagedealt(0);
        this.primaryStage = primaryStage;

        introScreen(primaryStage);

        primaryStage.setResizable(false);
        primaryStage.setScene(intro);
        primaryStage.setTitle("Dungeon Crawler");
        primaryStage.show();

    }

    /**
     * Creates start screen.
     * @param primaryStage the stage passed in.
     */
    private void startScreen(Stage primaryStage) {

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

                gameScreen(primaryStage);

                primaryStage.setScene(game);

            }
        });
    }
    private void introScreen(Stage primaryStage) {

        //Create the intro Screen
        VBox box = new VBox(75);
        Text introText = new Text("Welcome to Dungeons and Debuggers! "
                + "Press Start Game to continue");

        Button introBtn = new Button("Start");

        introBtn.setStyle("-fx-font-size:20");

        introBtn.setMaxWidth(150);
        box.getChildren().addAll(introText, introBtn);

        intro = new Scene(box, 525, 525);
        box.setAlignment(Pos.CENTER);

        //Move to start screen
        introBtn.setOnMouseClicked(e -> {
            startScreen(primaryStage);
            primaryStage.setScene(start);
        });



    }
    private void gameScreen(Stage stage)  {
        //Player Creation

        //Main screen of the game
        BorderPane screen = new BorderPane();
        // Top UI for the game we can see for money
        HBox uI = new HBox(20);
        moneyAmount = 0;
        if (level == Difficulty.EASY) {
            moneyAmount = 1000;
        } else if ((level == Difficulty.MEDIUM)) {
            moneyAmount = 500;
        }
        Text money = new Text("Money:" + moneyAmount);
        money.setId("money");

        mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        mainPlayer.getHealthLbl().setTextFill(Color.WHITE);

        UpdateTimer updateTime = new UpdateTimer(this.mainPlayer);
        timer.schedule(updateTime,1,500);


        uI.getChildren().addAll(money);

        //Player Creation

        BorderPane battleScreen = new BorderPane();
        StackPane playerScreen = new StackPane();
        playerScreen.setAlignment(Pos.CENTER);

        Rectangle player = new Rectangle(50, 50);

        playerScreen.getChildren().addAll(player,mainPlayer.getHealthLbl());
        battleScreen.setCenter(playerScreen);

        //Create Exit Left
        //VBox left = new VBox();
        Rectangle exit1 = new Rectangle(100, 25);
        exit1.setFill(Color.GREEN);
        exit1.setStroke(Color.GREEN);
        exit1.setId("exit1");


        Rectangle exit2 = new Rectangle(100, 25);
        exit2.setFill(Color.GREEN);
        exit2.setStroke(Color.GREEN);
        exit2.setId("exit2");

        HBox bottom = new HBox();
        Rectangle exit3 = new Rectangle(100, 25);
        exit3.setFill(Color.GREEN);
        exit3.setStroke(Color.GREEN);
        exit3.setId("exit3");

        Rectangle exit4 = new Rectangle(100, 25);
        exit4.setFill(Color.GREEN);
        exit4.setStroke(Color.GREEN);
        exit4.setId("exit4");

        bottom.setSpacing(30);
        bottom.getChildren().addAll(exit1, exit2, exit3, exit4);
        bottom.setAlignment(Pos.CENTER);


        screen.setTop(uI);
        screen.setCenter(battleScreen);
        screen.setBottom(bottom);

        game = new Scene(screen, 525, 525);


        int rand = (int) ((Math.random() * 4) + 1);
        // Exit 1
        if (rand == 1) {
            exit1.setOnMouseClicked(e -> {
                RoomController.path1(stage, game,mainPlayer);
            }
            );

            exit2.setOnMouseClicked(e -> {

                RoomController.path2(stage, game,mainPlayer);
            }
            );

            exit3.setOnMouseClicked(e -> {
                RoomController.path3(stage, game,mainPlayer);
            }
            );
            // Exit 4
            exit4.setOnMouseClicked(e -> {
                RoomController.path4(stage, game,mainPlayer);
            }
            );
        } else if (rand == 2) {
            exit1.setOnMouseClicked(e -> {
                RoomController.path2(stage, game,mainPlayer);
            }
            );
            exit2.setOnMouseClicked(e -> {
                RoomController.path3(stage, game,mainPlayer);
            }
            );
            exit3.setOnMouseClicked(e -> {
                RoomController.path4(stage, game,mainPlayer);
            }
            );
            // Exit 4
            exit4.setOnMouseClicked(e -> {
                RoomController.path1(stage, game,mainPlayer);
            }
            );
        } else if (rand == 3) {
            exit1.setOnMouseClicked(e -> {
                RoomController.path3(stage, game,mainPlayer);
            }
            );
            exit2.setOnMouseClicked(e -> {
                RoomController.path4(stage, game,mainPlayer);
            }
            );
            exit3.setOnMouseClicked(e -> {
                RoomController.path1(stage, game,mainPlayer);
            }
            );
            // Exit 4
            exit4.setOnMouseClicked(e -> {
                RoomController.path2(stage, game,mainPlayer);
            }
            );
        } else if (rand == 4) {
            exit1.setOnMouseClicked(e -> {
                RoomController.path4(stage, game,mainPlayer);
            }
            );

            exit2.setOnMouseClicked(e -> {
                RoomController.path1(stage, game,mainPlayer);
            }
            );

            exit3.setOnMouseClicked(e -> {
                RoomController.path2(stage, game,mainPlayer);
            }
            );

            // Exit 4
            exit4.setOnMouseClicked(e -> {
                RoomController.path3(stage, game,mainPlayer);
            }
            );
        }
    }


    public Player getMainPlayer() {
        return mainPlayer;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static int getMoneyAmount() {
        return moneyAmount;
    }

    public void restart(){
        startScreen(primaryStage);
    /*    mainPlayer.setPlayerHealth(100);
        getPrimaryStage().setScene(intro);*/
    };
    public static Stage getPrimaryStage(){
        return primaryStage;
    }
}
