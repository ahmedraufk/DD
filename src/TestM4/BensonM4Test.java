import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class BensonM4Test extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen cScreen = new InitialConfigurationScreen();
        cScreen.start(primaryStage);
    }

    @Test
    public void checkMonsterHealthAfterAttacking() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("SWORD");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#winPath");
        clickOn("HP:15");
        verifyThat("HP:10", NodeMatchers.isNotNull());

    }
    @Test
    public void checkPlayerHealthAfterAttacking() {
        clickOn("Start");
        clickOn("Select Difficulty");
        clickOn("EASY");
        clickOn("Select Weapon");
        clickOn("SWORD");
        clickOn("Name:");
        type(KeyCode.A);
        clickOn("Start");
        clickOn("#winPath");
        clickOn("HP:15");
        verifyThat("HP:98", NodeMatchers.isNotNull());

    }
}
