package main;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import main.InitialConfigurationScreen;
import main.Room;
public class RoomController {

    public static void path1(Stage stage, Scene startRoom){

        //Room Class Creation
        Room room1 = new Room(startRoom,null,doorSelect.TOP,doorSelect.BOTTOM,stage);

        //Create scene
        Scene room1Scene = room1.getRoomScene();

        //Get the scene from the class
        Room room2 = new Room(room1Scene,null,doorSelect.TOP,null,stage);

        Scene room2Scene = room2.getRoomScene();

        //Set the next exit for room 1
        room1.setNextExit(room2Scene,stage);

        stage.setScene(room1Scene);

    };
    
    public static void path2(Stage stage, Scene startRoom){

        Room firstRoom = new Room(startRoom, null, doorSelect.TOP, doorSelect.RIGHT, stage);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null, doorSelect.LEFT, doorSelect.TOP, stage);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null, doorSelect.BOTTOM, doorSelect.TOP, stage);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, doorSelect.BOTTOM, null, stage);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene,stage);

        secondRoom.setNextExit(thirdRoomScene,stage);

        thirdRoom.setNextExit(fourthRoomScene,stage);

        stage.setScene(firstRoomScene);

    }

    public static void path3(Stage stage, Scene startRoom){
        Room firstRoom = new Room(startRoom, null, doorSelect.TOP, doorSelect.BOTTOM, stage);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null, doorSelect.TOP, doorSelect.BOTTOM, stage);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null, doorSelect.TOP, doorSelect.RIGHT, stage);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, doorSelect.LEFT, doorSelect.RIGHT, stage);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        Room fifthRoom = new Room(fourthRoomScene, null, doorSelect.LEFT, doorSelect.BOTTOM, stage);

        Scene fifthRoomScene = fifthRoom.getRoomScene();

        Room sixthRoom = new Room(fifthRoomScene, null, doorSelect.TOP, doorSelect.LEFT, stage);

        Scene sixthRoomScene = sixthRoom.getRoomScene();

        Room seventhRoom = new Room(fifthRoomScene, null, doorSelect.RIGHT, doorSelect.BOTTOM, stage);

        Scene seventhRoomScene = seventhRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene,stage);

        secondRoom.setNextExit(thirdRoomScene,stage);

        thirdRoom.setNextExit(fourthRoomScene,stage);

        fourthRoom.setNextExit(fifthRoomScene,stage);

        fifthRoom.setNextExit(sixthRoomScene,stage);

        sixthRoom.setNextExit(seventhRoomScene,stage);

        stage.setScene(firstRoomScene);
    }

    public static void path4(Stage stage, Scene startRoom){
        Room firstRoom = new Room(startRoom, null, doorSelect.TOP, doorSelect.BOTTOM, stage);

        Scene firstRoomScene = firstRoom.getRoomScene();

        Room secondRoom = new Room(firstRoomScene, null, doorSelect.TOP, doorSelect.RIGHT, stage);

        Scene secondRoomScene = secondRoom.getRoomScene();

        Room thirdRoom = new Room(secondRoomScene, null, doorSelect.LEFT, doorSelect.BOTTOM, stage);

        Scene thirdRoomScene = thirdRoom.getRoomScene();

        Room fourthRoom = new Room(thirdRoomScene, null, doorSelect.TOP, null, stage);

        Scene fourthRoomScene = fourthRoom.getRoomScene();

        firstRoom.setNextExit(secondRoomScene,stage);

        secondRoom.setNextExit(thirdRoomScene,stage);

        thirdRoom.setNextExit(fourthRoomScene,stage);

        stage.setScene(firstRoomScene);
    }

    public enum doorSelect{
        LEFT,RIGHT,BOTTOM, TOP
    }
}
