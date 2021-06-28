

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextMatchers.hasText;

import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.WindowMatchers;

public class M2Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen init = new InitialConfigurationScreen();
        init.start(primaryStage);
    }
    @Test
    public void testEmptyName() {
        clickOn("Start");
        clickOn("Start");
        verifyThat(window("Error Detected"), WindowMatchers.isShowing());
    }
    @Test
    public void testScreenNavigation() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        write("Name");
        clickOn("Start");
        verifyThat("#money", hasText("Money:1000"));
    }
}