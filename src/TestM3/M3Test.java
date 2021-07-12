

import static org.testfx.api.FxAssert.verifyThat;


import javafx.scene.Node;

import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


public class M3Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen init = new InitialConfigurationScreen();
        init.start(primaryStage);
    }
    @Test
    public void testSixTraversal() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        write("Name");
        clickOn("Start");
        int i = 0;
        while (i < 6) {
            clickOn("#exit1");
            clickOn("#exit2");
            clickOn("#exit3");
            clickOn("#exit4");
            i++;
        }
    }
    @Test
    public void testSamePath() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        write("Name");
        clickOn("Start");
        clickOn("#exit1");
        verifyThat("#exit1", Node::isVisible);
        clickOn("#exit4");
        clickOn("#exit1");

    }
}