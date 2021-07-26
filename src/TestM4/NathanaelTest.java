package TestM4;

import static org.testfx.api.FxAssert.verifyThat;


import javafx.scene.Node;

import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.util.WaitForAsyncUtils;


public class NathanaelTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen init = new InitialConfigurationScreen();
        init.start(primaryStage);
    }
    @Test
    public void testDeathScreen() throws InterruptedException {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        write("Name");
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
        for(int i = 0; i < 7;i++){
            clickOn("#prev");
        }
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
        verifyThat("You have died! Press the Button to restart", Node::isVisible);
    }
    @Test
    public void testRestartButton() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        write("Name");
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
        for(int i = 0; i < 7;i++){
            clickOn("#prev");
        }
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
        clickOn("Play Again");
        verifyThat("#start", Node::isVisible);
    }
}