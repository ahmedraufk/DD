package main;

import javafx.application.Platform;

import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;

public class AttackTimer extends TimerTask {

    private Player mainPlayer;
    private Player enemyPlayer;
    private Timer timer;

    public AttackTimer(Player mainPlayer,Player enemyPlayer){
        this.mainPlayer = mainPlayer;
        this.enemyPlayer = enemyPlayer;
    }
    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            public void run() {
                mainPlayer.attackPlayer(enemyPlayer);

            }
        });

    }

    public void start() {
        timer = new Timer();
        timer.schedule(this,4000,4000);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException exc){}
    }
}
