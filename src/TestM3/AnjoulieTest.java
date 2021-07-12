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
    public void checkGoBackOneRoom() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("SWORD");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit1");
        clickOn("#exit1");
        verifyThat("#exit1", NodeMatchers.isNotNull());

    }

    @Test
    public void checkBackandForthRoom() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("MEDIUM");
        clickOn("Select Weapon");
        clickOn("SWORD");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#exit2");
        clickOn("#exit2");
        clickOn("#exit3");
        clickOn("#exit3");
        clickOn("#exit4");
        clickOn("#exit4");
        verifyThat("exit4", NodeMatchers.isNotNull());
    }
}
