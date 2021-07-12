package Test;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextMatchers.hasText;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.WindowMatchers;

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
        while(i < 6) {
            clickOn("#exit1");
            clickOn("#exit2");
            clickOn("#exit3");
            clickOn("#exit4");
            i++;
        }
    }
    @Test
    public void testReverseTraversal() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        write("Name");
        clickOn("Start");
        clickOn("#exit1");
        clickOn(650, 100);
        verifyThat("#exit1", Node::isVisible);
    }
}