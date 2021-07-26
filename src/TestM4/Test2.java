import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class Test2 extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen cScreen = new InitialConfigurationScreen();
        cScreen.start(primaryStage);
    }
    //Tests to see if the exit is locked and win screen doesnt show until all monsters are defeated
    @Test
    public void checkExitLocked() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#winPath");
        for(int i = 0; i < 7;i++){
            clickOn("#monster1");
            clickOn("#monster1");
            clickOn("#monster2");
            clickOn("#monster2");
            clickOn("#monster2");
            clickOn("#nextC");
            clickOn("#next");
        }
        clickOn("#monster1");
        clickOn("#monster1");
        clickOn("#monster2");
        clickOn("#monster2");
        clickOn("#monster2");
        clickOn("#nextC");

        verifyThat("HP:0", NodeMatchers.isNotNull());
    }

    //Checks to see if win screen shows after exiting the dungeon
    @Test
    public void checkWinScreen() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#winPath");
        for(int i = 0; i < 7;i++){
            clickOn("#monster1");
            clickOn("#monster1");
            clickOn("#monster2");
            clickOn("#monster2");
            clickOn("#monster2");
            clickOn("#nextC");
            clickOn("#next");
        }
        clickOn("#monster1");
        clickOn("#monster1");
        clickOn("#monster2");
        clickOn("#monster2");
        clickOn("#monster2");
        clickOn("#monster3");
        clickOn("#monster3");
        clickOn("#monster3");
        clickOn("#monster3");
        clickOn("#nextC");
        clickOn("#next");
        verifyThat("Congrats! You have escaped the dungeon!", NodeMatchers.isNotNull());
    }


}