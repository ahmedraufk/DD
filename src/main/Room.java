package main;

import com.sun.webkit.dom.StyleSheetListImpl;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Room {
    private Scene roomScene;
    private Rectangle exit1 = new Rectangle(25, 100);
    private Rectangle exit2 = new Rectangle(25, 100);
    private Rectangle exit3 = new Rectangle(100, 25);
    private Rectangle exit4 = new Rectangle(100, 25);
    private RoomController.doorSelect door2p;

    /**
     * Creates the Room class
     * @param prevExit previous scene to enter
     * @param nextExit next scene to enter
     * @param Door1 previous door to enter from
     * @param Door2 next door to enter from
     * @param stage pass in the stage
     */
    public Room(Scene prevExit, Scene nextExit, RoomController.doorSelect Door1, RoomController.doorSelect Door2, Stage stage,boolean isExit){
        BorderPane screen = new BorderPane();
        door2p = Door2;


        //Player Creation
        StackPane playerScreen = new StackPane();
        playerScreen.setAlignment(Pos.CENTER);


        Rectangle player = new Rectangle(50, 50);
        playerScreen.getChildren().addAll(player);

        HBox uI = new HBox(145);
        int moneyAmount = InitialConfigurationScreen.getMoneyAmount();



        Text money = new Text("Money:" + moneyAmount);
        money.setId("money");
        uI.getChildren().addAll(money);



        //Left Door
        VBox left = new VBox();

        exit1 = new Rectangle(25, 100);
        //Checks which door to select
        if(Door1 == RoomController.doorSelect.LEFT || Door2 == RoomController.doorSelect.LEFT){
            exit1.setFill(Color.GREEN);
            exit1.setStroke(Color.GREEN);
        } else {
            exit1.setFill(Color.rgb(0, 0, 0, 0));
            exit1.setStroke(Color.rgb(0, 0, 0, 0));
        }


        left.getChildren().addAll(exit1);
        left.setAlignment(Pos.CENTER);

        //Create Exit Right
        VBox right = new VBox();
        exit2 = new Rectangle(25, 100);
        if(Door1 == RoomController.doorSelect.RIGHT || Door2 == RoomController.doorSelect.RIGHT){
            exit2.setFill(Color.GREEN);
            exit2.setStroke(Color.GREEN);
        } else {
            exit2.setFill(Color.rgb(0, 0, 0, 0));
            exit2.setStroke(Color.rgb(0, 0, 0, 0));
        }

        right.getChildren().addAll(exit2);
        right.setAlignment(Pos.CENTER);

        //Create Exit Bottom
        HBox bottom = new HBox();
        exit3 = new Rectangle(100, 25);
        if(Door1 == RoomController.doorSelect.BOTTOM || Door2 == RoomController.doorSelect.BOTTOM){
            if(!isExit){
                exit3.setFill(Color.GREEN);
                exit3.setStroke(Color.GREEN);
            } else {
                exit3.setFill(Color.RED);
                exit3.setStroke(Color.RED);
            }

        } else {
            exit3.setFill(Color.rgb(0, 0, 0, 0));
            exit3.setStroke(Color.rgb(0, 0, 0, 0));
        }

        //Create Exit top
        HBox top = new HBox();
        exit4 = new Rectangle(100, 25);
        if(Door1 == RoomController.doorSelect.TOP || Door2 == RoomController.doorSelect.TOP){
            exit4.setFill(Color.GREEN);
            exit4.setStroke(Color.GREEN);
        } else {
            exit4.setFill(Color.rgb(0, 0, 0, 0));
            exit4.setStroke(Color.rgb(0, 0, 0, 0));
        }

        uI.getChildren().addAll(exit4);
        //top.setAlignment(Pos.CENTER);


        //Set white color to doors we aren't using



        bottom.setSpacing(50);
        bottom.getChildren().addAll(exit3);
        bottom.setAlignment(Pos.CENTER);

        //Set screen

        screen.setTop(uI);
        screen.setBottom(bottom);
        screen.setRight(right);
        screen.setLeft(left);
        //screen.setTop(top);
        screen.setCenter(playerScreen);

        if(Door1 == RoomController.doorSelect.LEFT){
            exit1.setOnMouseClicked(e->{
                stage.setScene(prevExit);
            });
        } else if (Door1 == RoomController.doorSelect.RIGHT){
            exit2.setOnMouseClicked(e->{
                stage.setScene(prevExit);
            });
        } else if (Door1 == RoomController.doorSelect.BOTTOM){
            exit3.setOnMouseClicked(e->{
                stage.setScene(prevExit);
            });
        } else if (Door1 == RoomController.doorSelect.TOP){
            exit4.setOnMouseClicked(e->{
                stage.setScene(prevExit);
            });
        }

        if(Door2 == RoomController.doorSelect.LEFT){
            exit1.setOnMouseClicked(e->{
                stage.setScene(nextExit);
            });
        } else if (Door2 == RoomController.doorSelect.RIGHT){
            exit2.setOnMouseClicked(e->{
                stage.setScene(nextExit);
            });
        } else if (Door2 == RoomController.doorSelect.BOTTOM){
            exit3.setOnMouseClicked(e->{
                stage.setScene(nextExit);
            });
        } else if (Door2 == RoomController.doorSelect.TOP) {
            exit4.setOnMouseClicked(e -> {
                stage.setScene(nextExit);
            });
        }

        roomScene = new Scene(screen, 525, 525);
    }
    public Scene getRoomScene(){
        return roomScene;
    }

    public void setNextExit(Scene exit,Stage stage){
        if(door2p == RoomController.doorSelect.LEFT){
            exit1.setOnMouseClicked(e->{
                stage.setScene(exit);
            });
        } else if (door2p == RoomController.doorSelect.RIGHT){
            exit2.setOnMouseClicked(e->{
                stage.setScene(exit);
            });
        } else if (door2p == RoomController.doorSelect.BOTTOM){
            exit3.setOnMouseClicked(e->{
                stage.setScene(exit);
            });
        } else if (door2p == RoomController.doorSelect.TOP) {
            exit4.setOnMouseClicked(e -> {
                stage.setScene(exit);
            });
        }

    }
}
