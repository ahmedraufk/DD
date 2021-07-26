
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class Test1 extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen cScreen = new InitialConfigurationScreen();
        cScreen.start(primaryStage);
    }
    //Tests to see if the next room is locked when monsters are live
    @Test
    public void checkNextRoomLocked() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit1");
        clickOn("#monster1");
        clickOn("#nextC");
        verifyThat("HP:5", NodeMatchers.isNotNull());
    }

    //Checks to see if the next room opens after killing all the monsters
    @Test
    public void checkNextRoomOpen() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit1");
        clickOn("#monster1");
        clickOn("#monster1");
        clickOn("#monster2");
        clickOn("#monster2");
        clickOn("#monster2");
        clickOn("#nextC");
        clickOn("#next");
        verifyThat("HP:10", NodeMatchers.isNotNull());
    }


}