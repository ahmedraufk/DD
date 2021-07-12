import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class AhmedTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen cScreen = new InitialConfigurationScreen();
        cScreen.start(primaryStage);
    }

    @Test
    public void checkRoomSelection1() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit1");
        verifyThat("#exit2", NodeMatchers.isNotNull());

    }
    @Test
    public void checkRoomSelection2() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("AXE");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit2");
        verifyThat("#exit2", NodeMatchers.isNotNull());

    }
}
