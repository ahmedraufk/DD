package main;


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
    private RoomController.SelectDoor door2p;

    /**
     * Creates the Room class
     * @param prevExit previous scene to enter
     * @param nextExit next scene to enter
     * @param door1 previous door to enter from
     * @param door2 next door to enter from
     * @param stage pass in the stage
     * @param isExit is this room an exit
     */
    public Room(Scene prevExit, Scene nextExit, RoomController.SelectDoor door1,
                RoomController.SelectDoor door2, Stage stage, boolean isExit) {
        BorderPane screen = new BorderPane();
        door2p = door2;

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
        exit1.setId("exit1");
        //Checks which door to select
        if (door1 == RoomController.SelectDoor.LEFT || door2 == RoomController.SelectDoor.LEFT) {
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
        exit2.setId("exit2");
        if (door1 == RoomController.SelectDoor.RIGHT || door2 == RoomController.SelectDoor.RIGHT) {
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
        exit3.setId("exit3");
        if (door1 == RoomController.SelectDoor.BOTTOM
                || door2 == RoomController.SelectDoor.BOTTOM) {
            if (!isExit) {
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
        exit4.setId("exit4");
        if (door1 == RoomController.SelectDoor.TOP || door2 == RoomController.SelectDoor.TOP) {
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

        if (door1 == RoomController.SelectDoor.LEFT) {
            exit1.setOnMouseClicked(e -> {
                stage.setScene(prevExit);
            });
        } else if (door1 == RoomController.SelectDoor.RIGHT) {
            exit2.setOnMouseClicked(e -> {
                stage.setScene(prevExit);
            });
        } else if (door1 == RoomController.SelectDoor.BOTTOM) {
            exit3.setOnMouseClicked(e -> {
                stage.setScene(prevExit);
            });
        } else if (door1 == RoomController.SelectDoor.TOP) {
            exit4.setOnMouseClicked(e -> {
                stage.setScene(prevExit);
            });
        }

        if (door2 == RoomController.SelectDoor.LEFT) {
            exit1.setOnMouseClicked(e -> {
                stage.setScene(nextExit);
            });
        } else if (door2 == RoomController.SelectDoor.RIGHT) {
            exit2.setOnMouseClicked(e -> {
                stage.setScene(nextExit);
            });
        } else if (door2 == RoomController.SelectDoor.BOTTOM) {
            exit3.setOnMouseClicked(e -> {
                stage.setScene(nextExit);
            });
        } else if (door2 == RoomController.SelectDoor.TOP) {
            exit4.setOnMouseClicked(e -> {
                stage.setScene(nextExit);
            });
        }



        roomScene = new Scene(screen, 525, 525);
    }
    public Scene getRoomScene() {
        return roomScene;
    }
    public void setNextExit(Scene exit, Stage stage) {
        if (door2p == RoomController.SelectDoor.LEFT) {
            exit1.setOnMouseClicked(e -> {
                stage.setScene(exit);
            });
        } else if (door2p == RoomController.SelectDoor.RIGHT) {
            exit2.setOnMouseClicked(e -> {
                stage.setScene(exit);
            });
        } else if (door2p == RoomController.SelectDoor.BOTTOM) {
            exit3.setOnMouseClicked(e -> {
                stage.setScene(exit);
            });
        } else if (door2p == RoomController.SelectDoor.TOP) {
            exit4.setOnMouseClicked(e -> {
                stage.setScene(exit);
            });
        }

    }
}
