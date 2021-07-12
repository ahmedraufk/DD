import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class BensonTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen cScreen = new InitialConfigurationScreen();
        cScreen.start(primaryStage);
    }

    @Test
    public void checkRoomSelection3() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("SWORD");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit3");
        verifyThat("#exit4", NodeMatchers.isNotNull());

    }
    @Test
    public void checkRoomSelection4(){
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("SWORD");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit4");
        verifyThat("#exit4", NodeMatchers.isNotNull());

    }
}