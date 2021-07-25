package main;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Timer;

public class Room {
    private Scene roomScene;
    private Rectangle exit1 = new Rectangle(25, 100);
    private Rectangle exit2 = new Rectangle(25, 100);
    private Rectangle exit3 = new Rectangle(100, 25);
    private Rectangle exit4 = new Rectangle(100, 25);
    private Rectangle exit1Closed = new Rectangle(25, 100);
    private Rectangle exit2Closed = new Rectangle(25, 100);
    private Rectangle exit3Closed = new Rectangle(100, 25);
    private Rectangle exit4Closed = new Rectangle(100, 25);
    private RoomController.SelectDoor door2p;
    private RoomController.SelectDoor doorp;
    private Player mainPlayer;
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;
    private boolean isExit;
    private Scene nextExit;
    private Stage stage;
    private BorderPane screen;
    private HBox bottom = new HBox();
    private VBox right = new VBox();
    private VBox left = new VBox();
    private HBox uI = new HBox(145);
   // private int monsterNum;

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
                RoomController.SelectDoor door2, Stage stage, boolean isExit,Player mainPlayer) {
        this.mainPlayer = new Player(100,5);
        this.doorp = door1;
        this.isExit = isExit;
        this.stage = stage;
        this.nextExit = nextExit;
        this.mainPlayer.setPlayerHealth(mainPlayer.getPlayerHealth());
        //this.monsterNum = monsterNum;
        screen = new BorderPane();
        door2p = door2;

        //Player Creation
        BorderPane battleScreen = new BorderPane();
        StackPane playerScreen = new StackPane();
        playerScreen.setAlignment(Pos.CENTER);

        Rectangle player = new Rectangle(50, 50);


        this.mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        this.mainPlayer.getHealthLbl().setTextFill(Color.WHITE);

        UpdateTimer updateTime = new UpdateTimer(this.mainPlayer);

        Timer timer = new Timer();
        InitialConfigurationScreen.getTimer().schedule(updateTime,5,500);

        playerScreen.getChildren().addAll(player,this.mainPlayer.getHealthLbl());
        battleScreen.setCenter(playerScreen);
        //createMonsters(battleScreen);


        int moneyAmount = InitialConfigurationScreen.getMoneyAmount();



        Text money = new Text("Money:" + moneyAmount);
        money.setId("money");

        uI.getChildren().addAll(money);



        //Left Door

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

        //Add Monsters



        //screen.setTop(uI);
        //screen.setBottom(bottom);
       // screen.setRight(right);
        //screen.setLeft(left);
        //screen.setTop(top);
        screen.setCenter(battleScreen);

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
        createMonsters(battleScreen);





        roomScene = new Scene(screen, 525, 525);
    }
    public Scene getRoomScene() {
        return roomScene;
    }

    public void createMonsters(BorderPane battleScreen) {

        Rectangle leftEmpty = new Rectangle(50, 50);
        leftEmpty.setFill(Color.TRANSPARENT);
        Rectangle topEmpty = new Rectangle(50, 50);
        topEmpty.setFill(Color.TRANSPARENT);
        Rectangle rightEmpty = new Rectangle(50, 50);
        rightEmpty.setFill(Color.TRANSPARENT);
        Rectangle bottomEmpty = new Rectangle(50, 50);
        bottomEmpty.setFill(Color.TRANSPARENT);

        battleScreen.setLeft(leftEmpty);
        battleScreen.setBottom(bottomEmpty);
        battleScreen.setRight(rightEmpty);
        battleScreen.setTop(topEmpty);

        //1st monster on the left
        Monster monster1 = new Monster("square", mainPlayer, this);
        StackPane monsterScreen = monster1.createMonster();
        battleScreen.setLeft(monsterScreen);


        // AttackTimer attack1 = new AttackTimer(monster1,mainPlayer);
        //Timer timer = new Timer();
        //timer.schedule(attack1,2000);


        //2nd monster on the top
        Monster monster2 = new Monster("circle", mainPlayer, this);
        StackPane monster2Screen = monster2.createMonster();
        battleScreen.setTop(monster2Screen);

        //3rd Monster on the right
        Monster monster3 = new Monster("triangle", mainPlayer, this);
        StackPane monster3Screen = monster3.createMonster();
        battleScreen.setRight(monster3Screen);


        int moneyAmount = InitialConfigurationScreen.getMoneyAmount();



        Text money = new Text("Money:" + moneyAmount);
        money.setId("money");

      /*  if (doorp == RoomController.SelectDoor.LEFT ) {
            left.getChildren().addAll(exit1);
        } else if (doorp == RoomController.SelectDoor.RIGHT){
            right.getChildren().addAll(exit2);
        } else if(doorp == RoomController.SelectDoor.BOTTOM){
            bottom.getChildren().addAll(exit3);
        } else if(doorp == RoomController.SelectDoor.TOP){
            uI.getChildren().addAll(exit4);
        }*/


        if (door2p == RoomController.SelectDoor.LEFT) {
            left.getChildren().remove(exit1);

            exit1Closed.setOnMouseClicked(e -> {
                if (monster1.getHealth() == 0 && monster2.getHealth() == 0) {
                    left.getChildren().clear();
                    left.getChildren().addAll(exit1);

                    screen.setLeft(left);
                }
            });


            left.getChildren().addAll(exit1Closed);


        } else if (door2p == RoomController.SelectDoor.RIGHT) {
            right.getChildren().remove(exit2);
            exit2Closed.setOnMouseClicked(e -> {
                if (monster1.getHealth() == 0 && monster2.getHealth() == 0) {
                    right.getChildren().clear();
                    right.getChildren().addAll(exit2);
                    right.setAlignment(Pos.CENTER);
                    screen.setRight(right);
                }
            });
            right.getChildren().addAll(exit2Closed);
            right.setAlignment(Pos.CENTER);

        } else if (door2p == RoomController.SelectDoor.BOTTOM) {
            bottom.getChildren().remove(exit3);

            exit3Closed.setOnMouseClicked(e -> {
                if(isExit){
                    if (monster1.getHealth() == 0 && monster2.getHealth() == 0 && monster3.getHealth() == 0) {
                        bottom.getChildren().clear();
                        bottom.getChildren().addAll(exit3);
                        bottom.setAlignment(Pos.CENTER);
                        screen.setBottom(bottom);
                    }
                } else {
                    if (monster1.getHealth() == 0 && monster2.getHealth() == 0) {
                        bottom.getChildren().clear();
                        bottom.getChildren().addAll(exit3);
                        bottom.setAlignment(Pos.CENTER);
                        screen.setBottom(bottom);
                    }
                }

            });
            bottom.getChildren().addAll(exit3Closed);
            bottom.setAlignment(Pos.CENTER);


        } else if (door2p == RoomController.SelectDoor.TOP) {
            uI.getChildren().remove(exit4);
            exit4Closed.setOnMouseClicked(e -> {
                if (monster1.getHealth() == 0 && monster2.getHealth() == 0) {
                    uI.getChildren().addAll(exit4);
                    uI.getChildren().remove(exit4Closed);

                }
            });
            uI.getChildren().addAll(exit4Closed);


        }
        screen.setLeft(left);
        screen.setRight(right);
        screen.setBottom(bottom);
        screen.setTop(uI);
        if (!this.isExit) {
            battleScreen.setRight(rightEmpty);
        }
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
    public Stage getStage(){
        return stage;
    }


}
