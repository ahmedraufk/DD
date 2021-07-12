package main;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
public class RoomController {

    public static void path1(Stage stage, Scene startRoom) {

        //Room Class Creation
        Room room1 = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, false);

        //Create scene
        Scene room1Scene = room1.getRoomScene();

        //Get the scene from the class
        Room room2 = new Room(room1Scene, null, SelectDoor.TOP, null, stage, false);

        Scene room2Scene = room2.getRoomScene();

        //Set the next exit for room 1
        room1.setNextExit(room2Scene, stage);

        stage.setScene(room1Scene);

    };
    
    public static void path2(Stage stage, Scene startRoom) {

        Room firstRoom = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.RIGHT, stage, false);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null,
                SelectDoor.LEFT, SelectDoor.TOP, stage, false);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null,
                SelectDoor.BOTTOM, SelectDoor.TOP, stage, false);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, SelectDoor.BOTTOM, null, stage, false);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene, stage);

        secondRoom.setNextExit(thirdRoomScene, stage);

        thirdRoom.setNextExit(fourthRoomScene, stage);

        stage.setScene(firstRoomScene);

    }

    public static void path3(Stage stage, Scene startRoom) {
        Room firstRoom = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, false);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null,
                SelectDoor.TOP, SelectDoor.BOTTOM, stage, false);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null,
                SelectDoor.TOP, SelectDoor.RIGHT, stage, false);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null,
                SelectDoor.LEFT, SelectDoor.RIGHT, stage, false);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        Room fifthRoom = new Room(fourthRoomScene, null,
                SelectDoor.LEFT, SelectDoor.BOTTOM, stage, false);

        Scene fifthRoomScene = fifthRoom.getRoomScene();

        Room sixthRoom = new Room(fifthRoomScene, null,
                SelectDoor.TOP, SelectDoor.LEFT, stage, false);

        Scene sixthRoomScene = sixthRoom.getRoomScene();

        Room seventhRoom = new Room(fifthRoomScene, null,
                SelectDoor.RIGHT, SelectDoor.BOTTOM, stage, false);

        Scene seventhRoomScene = seventhRoom.getRoomScene();

        Room eighthRoom = new Room(seventhRoomScene,
                null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, true);

        Scene eighthRoomScene = eighthRoom.getRoomScene();





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
        win.getChildren().addAll(winText);
        win.setAlignment(Pos.CENTER);
        Scene winScene = new Scene(win, 525, 525);
        eighthRoom.setNextExit(winScene, stage);



        stage.setScene(firstRoomScene);
    }

    public static void path4(Stage stage, Scene startRoom) {
        Room firstRoom = new Room(startRoom, null, SelectDoor.TOP, SelectDoor.BOTTOM, stage, false);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene,
                null, SelectDoor.TOP, SelectDoor.RIGHT, stage, false);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene,
                null, SelectDoor.LEFT, SelectDoor.BOTTOM, stage, false);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, SelectDoor.TOP, null, stage, false);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene, stage);

        secondRoom.setNextExit(thirdRoomScene, stage);

        thirdRoom.setNextExit(fourthRoomScene, stage);

        stage.setScene(firstRoomScene);
    }

    public enum SelectDoor {
        LEFT, RIGHT, BOTTOM, TOP
    }
}
