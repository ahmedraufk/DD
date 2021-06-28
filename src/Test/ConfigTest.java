
import javafx.stage.Stage;
import main.InitialConfigurationScreen;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class ConfigTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialConfigurationScreen cScreen = new InitialConfigurationScreen();
        cScreen.start(primaryStage);
    }
    @Test
    public void findWeaponSelection() {
        clickOn("Start");
        verifyThat("Select Weapon", NodeMatchers.isNotNull());

    }

    @Test
    public void findDifficultySelection() {
        clickOn("Start");
        verifyThat("Select Difficulty", NodeMatchers.isNotNull());

    }


}
