package main;

import javafx.scene.paint.Color;

import java.util.TimerTask;

public class UpdateTimer extends TimerTask {
    private Player mainPlayer;
    private Player enemyPlayer;

    public UpdateTimer(Player mainPlayer){
        this.mainPlayer = mainPlayer;

    }
    @Override
    public void run() {
        mainPlayer.getHealthLbl().setText("HP:" + mainPlayer.getPlayerHealth());
        mainPlayer.getHealthLbl().setTextFill(Color.WHITE);

    }
}
