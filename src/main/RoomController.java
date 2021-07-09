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
        Room room1 = new Room(startRoom,null,doorSelect.RIGHT,doorSelect.LEFT,stage);

        //Create scene
        Scene room1Scene = room1.getRoomScene();

        //Get the scene from the class
        Room room2 = new Room(room1Scene,null,doorSelect.RIGHT,null,stage);


        Scene room2Scene = room2.getRoomScene();

        //Set the next exit for room 1
        room1.setNextExit(room2Scene,stage);

        Scene room3 = null;


        stage.setScene(room1Scene);

    };



    //private void path2();

    //private void path3();

    //private void path4();


    public enum doorSelect{
        LEFT,RIGHT,BOTTOM
    }
}
