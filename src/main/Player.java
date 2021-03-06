package main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Player {
    private int health;
    private int attack;
    private Label healthLbl = new Label();
    private boolean typePlayer = true;
    private static int playerHealth;
    private static int defeated;
    private static int damagedealt;

    public Player(int health, int attack){
        this.health = health;
        this.attack = attack;
    }

    public static void setPlayerHealth(int playerHealth) {
        Player.playerHealth = playerHealth;
    }
    public static int getPlayerHealth(){
        return playerHealth;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
    public Label getHealthLbl(){
        return this.healthLbl;
    }

    public void setTypePlayer(boolean typePlayer) {
        this.typePlayer = typePlayer;
    }

    public boolean isTypePlayer() {
        return typePlayer;
    }

    public int getDefeated() { return defeated; }
    public void setDefeated(int death) { this.defeated = death; }
    public int getDamagedealt() { return damagedealt; }
    public static void inDefeat(){
        defeated++;
    }

    public void attackPlayer(Player enemy){


        if(enemy.isTypePlayer()){


            enemy.setPlayerHealth(enemy.getPlayerHealth()-this.getAttack());

            if(enemy.getPlayerHealth() <= 0){
                enemy.setPlayerHealth(0);
                damagedealt += attack;
            }
            enemy.getHealthLbl().setText("HP:" + enemy.getPlayerHealth());
            enemy.getHealthLbl().setTextFill(Color.WHITE);

        } else {
            enemy.setHealth(enemy.getHealth()-this.getAttack());
            if(enemy.getHealth() <= 0){
                enemy.setHealth(0);
                damagedealt += attack;
            }
            enemy.getHealthLbl().setText("HP:" + enemy.getHealth());
        }

    }

    public static void setDamagedealt(int damagedealt) {
        Player.damagedealt = damagedealt;
    }
}
