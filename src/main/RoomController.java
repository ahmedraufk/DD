package main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
public class RoomController {
    private static Text defeated;
    private static Text damageDealt;
    private static Text damageTaken;
    private static Room eightRoom;

    public static void path1(Stage stage, Scene startRoom,Player mainPlayer) {
        mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        mainPlayer.getHealthLbl().setTextFill(Color.WHITE);

        //Room Class Creation
        Room room1 = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, false,mainPlayer);

        //Create scene
        Scene room1Scene = room1.getRoomScene();

        //Get the scene from the class
        Room room2 = new Room(room1Scene, null, SelectDoor.TOP, null, stage, false,mainPlayer);

        Scene room2Scene = room2.getRoomScene();

        //Set the next exit for room 1
        room1.setNextExit(room2Scene, stage);

        stage.setScene(room1Scene);

    };
    
    public static void path2(Stage stage, Scene startRoom,Player mainPlayer) {
        mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        mainPlayer.getHealthLbl().setTextFill(Color.WHITE);

        Room firstRoom = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.RIGHT, stage, false,mainPlayer);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null,
                SelectDoor.LEFT, SelectDoor.TOP, stage, false,mainPlayer);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null,
                SelectDoor.BOTTOM, SelectDoor.TOP, stage, false,mainPlayer);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, SelectDoor.BOTTOM, null, stage, false,mainPlayer);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene, stage);

        secondRoom.setNextExit(thirdRoomScene, stage);

        thirdRoom.setNextExit(fourthRoomScene, stage);

        stage.setScene(firstRoomScene);

    }

    public static void path3(Stage stage, Scene startRoom,Player mainPlayer) {
        mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        mainPlayer.getHealthLbl().setTextFill(Color.WHITE);
        Room firstRoom = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, false,mainPlayer);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null,
                SelectDoor.TOP, SelectDoor.BOTTOM, stage, false,mainPlayer);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null,
                SelectDoor.TOP, SelectDoor.RIGHT, stage, false,mainPlayer);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null,
                SelectDoor.LEFT, SelectDoor.RIGHT, stage, false,mainPlayer);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        Room fifthRoom = new Room(fourthRoomScene, null,
                SelectDoor.LEFT, SelectDoor.BOTTOM, stage, false,mainPlayer);

        Scene fifthRoomScene = fifthRoom.getRoomScene();

        Room sixthRoom = new Room(fifthRoomScene, null,
                SelectDoor.TOP, SelectDoor.LEFT, stage, false,mainPlayer);

        Scene sixthRoomScene = sixthRoom.getRoomScene();

        Room seventhRoom = new Room(fifthRoomScene, null,
                SelectDoor.RIGHT, SelectDoor.BOTTOM, stage, false,mainPlayer);

        Scene seventhRoomScene = seventhRoom.getRoomScene();

        eightRoom = new Room(seventhRoomScene,
                null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, true,mainPlayer);

        Scene eighthRoomScene = eightRoom.getRoomScene();





        firstRoom.setNextExit(secondRoomScene, stage);

        secondRoom.setNextExit(thirdRoomScene, stage);

        thirdRoom.setNextExit(fourthRoomScene, stage);

        fourthRoom.setNextExit(fifthRoomScene, stage);

        fifthRoom.setNextExit(sixthRoomScene, stage);

        sixthRoom.setNextExit(seventhRoomScene, stage);

        seventhRoom.setNextExit(eighthRoomScene, stage);

        //Win Screen Creation
        VBox win = new VBox(75);
        Text winText = new Text("Congrats! You have escaped the dungeon!");
        defeated = new Text("Enemies defeated:" + mainPlayer.getDefeated());
        damageTaken = new Text("Damage taken:" + (100 - mainPlayer.getHealth()));
        damageDealt = new Text("Damage dealt:" + mainPlayer.getDamagedealt());
        Label lbldt = new Label(damageTaken.getText());
        Label lbldd = new Label(damageDealt.getText());
        Label lbl = new Label(defeated.getText());
        lbl.textProperty().bind(defeated.textProperty());
        lbldd.textProperty().bind(damageDealt.textProperty());
        lbldt.textProperty().bind(damageTaken.textProperty());

        Button retry = new Button("Play Again");
        retry.setOnAction(e -> {
                    InitialConfigurationScreen newGame = new InitialConfigurationScreen();
                    newGame.start(InitialConfigurationScreen.getPrimaryStage());
                }
        );
        Button exit = new Button("Exit");
        exit.setOnAction(e -> {
            Platform.exit();
        });
        win.getChildren().addAll(winText, lbl, lbldt, lbldd, retry, exit);
        win.setAlignment(Pos.CENTER);
        Scene winScene = new Scene(win, 525, 525);

        eightRoom.setNextExit(winScene, stage);



        stage.setScene(firstRoomScene);
    }

    public static void path4(Stage stage, Scene startRoom,Player mainPlayer) {
        mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        mainPlayer.getHealthLbl().setTextFill(Color.WHITE);
        Room firstRoom = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, false,mainPlayer);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene,
                null, SelectDoor.TOP, SelectDoor.RIGHT, stage, false,mainPlayer);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene,
                null, SelectDoor.LEFT, SelectDoor.BOTTOM, stage, false,mainPlayer);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, SelectDoor.TOP, null, stage, false,mainPlayer);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene, stage);

        secondRoom.setNextExit(thirdRoomScene, stage);

        thirdRoom.setNextExit(fourthRoomScene, stage);

        stage.setScene(firstRoomScene);
    }

    public enum SelectDoor {
        LEFT, RIGHT, BOTTOM, TOP
    }
    public static void setDefeated(Text text){
        defeated = text;
    }

    public static Room getEightRoom() {
        return eightRoom;
    }
}
