package main;

import javafx.animation.FadeTransition;
import javafx.animation.StrokeTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.util.Stack;

public class Monster extends Player {

    private String type;
    private Player mainPlayer;
    private Room room;
    private boolean death;


    public Monster(String type,Player mainPlayer,Room room){
        super(0,0);
        this.mainPlayer = mainPlayer;
        this.setTypePlayer(false);
        this.room = room;
        death = false;


        if(type.equals("square")){
            this.setHealth(10);
            this.setAttack(1);
        }

        if(type.equals("circle")){
            this.setHealth(15);
            this.setAttack(2);
        }
        if(type.equals("triangle")){
            this.setHealth(20);
            this.setAttack(4);
        }

        this.type = type;
    }

    public StackPane createMonster(){
        if(type.equals("square")){
            StackPane monsterScreen = new StackPane();
            monsterScreen.setAlignment(Pos.CENTER);
            Rectangle monster = new Rectangle(50, 50);
            monster.setFill(Color.RED);
            FadeTransition animate = new FadeTransition();
            animate.setDuration(Duration.millis(500));
            animate.setFromValue(10);
            animate.setToValue(0.1);

            animate.setCycleCount(2);
            animate.setAutoReverse(true);
            animate.setNode(monster);
            final Label lbl = new Label();
            getHealthLbl().setText("HP:" + this.getHealth());
            monsterScreen.getChildren().addAll(monster,getHealthLbl());
            monsterScreen.setOnMouseClicked(e->{
                animate.play();
                mainPlayer.attackPlayer(this);


                if(this.getHealth() > 0){
                    this.attackPlayer(mainPlayer);
                } else {
                    if(!monster.getFill().equals(Color.WHITE)){
                        monster.setFill(Color.WHITE);
                        mainPlayer.inDefeat();
                        Text defeat = new Text("Enemies defeated:" + mainPlayer.getDefeated());
                        RoomController.setDefeated(defeat);
                        try{
                            RoomController.getEightRoom().setNextExit(createWinScreen(),room.getStage());
                        } catch (NullPointerException ex){

                        }
                    }

                }
                if(mainPlayer.getPlayerHealth() == 0){
                    this.deathScene();
                }




            });
            return monsterScreen;
        }
        if(type.equals("circle")){
            StackPane monsterScreen = new StackPane();
            monsterScreen.setAlignment(Pos.CENTER);
            Circle monster = new Circle(30);
            monster.setFill(Color.RED);
            getHealthLbl().setText("HP:" + this.getHealth());
            FadeTransition animate = new FadeTransition();
            animate.setDuration(Duration.millis(500));
            animate.setFromValue(10);
            animate.setToValue(0.1);

            animate.setCycleCount(2);
            animate.setAutoReverse(true);
            animate.setNode(monster);
            monsterScreen.getChildren().addAll(monster,getHealthLbl());
            monsterScreen.setOnMouseClicked(e->{
                animate.play();
                mainPlayer.attackPlayer(this);
                if(this.getHealth() > 0){
                    this.attackPlayer(mainPlayer);
                } else {
                    if(!monster.getFill().equals(Color.WHITE)){
                        monster.setFill(Color.WHITE);
                        mainPlayer.inDefeat();
                        Text defeat = new Text("Enemies defeated:" + mainPlayer.getDefeated());
                        RoomController.setDefeated(defeat);
                        try{
                            RoomController.getEightRoom().setNextExit(createWinScreen(),room.getStage());
                        } catch (NullPointerException ex){

                        }
                    }

                }

                if(mainPlayer.getPlayerHealth() == 0){
                    this.deathScene();
                }

            });
            return monsterScreen;
        }
        if(type.equals("triangle")){
            StackPane monsterScreen = new StackPane();
            monsterScreen.setAlignment(Pos.CENTER);
            Polygon triangle = new Polygon();
            triangle.getPoints()
                    .addAll(new Double[] {300.0, 50.0, 270.0, 100.0, 330.0, 100.0,});
            triangle.setFill(Color.RED);
            Group monster = new Group(triangle);
            getHealthLbl().setText("HP:" + this.getHealth());
            FadeTransition animate = new FadeTransition();
            //Create Animation
            animate.setDuration(Duration.millis(500));
            animate.setFromValue(10);
            animate.setToValue(0.1);
            animate.setCycleCount(2);
            animate.setAutoReverse(true);
            animate.setNode(monster);
            monsterScreen.getChildren().addAll(monster,getHealthLbl());
            monsterScreen.setOnMouseClicked(e->{

                animate.play();
                mainPlayer.attackPlayer(this);
                if(this.getHealth() > 0){
                    this.attackPlayer(mainPlayer);
                } else {
                    if(!triangle.getFill().equals(Color.WHITE)){
                        triangle.setFill(Color.WHITE);
                        mainPlayer.inDefeat();
                        Text defeat = new Text("Enemies defeated:" + mainPlayer.getDefeated());
                        RoomController.setDefeated(defeat);
                        try{
                            RoomController.getEightRoom().setNextExit(createWinScreen(),room.getStage());
                        } catch (NullPointerException ex){

                        }
                    }
                }
                if(mainPlayer.getPlayerHealth() == 0){
                    this.deathScene();
                }


            });
            return monsterScreen;
        }
        return null;
    }

    public String getType(){
        return this.type;
    }

    public void deathScene(){
        VBox win = new VBox(75);
        Text winText = new Text("You have died! Press the Button to restart");
        Text defeated = new Text("Enemies defeated:" + mainPlayer.getDefeated());
        Text damageTaken = new Text("Damage taken:" + (100 - mainPlayer.getPlayerHealth()));
        Text damageDealt = new Text("Damage dealt:" + mainPlayer.getDamagedealt());
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
        win.getChildren().addAll(winText, lbl, lbldt, lbldd, retry,exit);
        win.setAlignment(Pos.CENTER);
        Scene winScene = new Scene(win, 525, 525);
        room.getStage().setScene(winScene);
    }
    public Scene createWinScreen(){
        VBox win = new VBox(75);
        Text winText = new Text("Congrats! You have escaped the dungeon!");
        Text defeated = new Text("Enemies defeated:" + mainPlayer.getDefeated());
        Text damageTaken = new Text("Damage taken:" + (100 - mainPlayer.getPlayerHealth()));
        Text damageDealt = new Text("Damage dealt:" + mainPlayer.getDamagedealt());
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
        return winScene;

    }
}
