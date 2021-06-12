import BoardManager.PrintableBoardState;
import BoardManager.iBoardStateManager;
import HeroManager.FakeHeroManager;
import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import UIManager.GameTimer;
import UIManager.UIManager;
import UIManager.iUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 ** App
 */
public class App extends Application {
    iBoardStateManager room;
    iUIManager userInterface = new UIManager();
    iHeroManager hero = new FakeHeroManager();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private void setUp(Stage primaryStage) {
        // GameLogic SetUp
        this.room.generateNewBoard();
        this.hero.placeHero();
        this.userInterface.setStage(primaryStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setUp(primaryStage);
        PrintableBoardState roomState = this.room.expPrintableBoardState();
        PrintableHeroStatus heroStatus = this.hero.expPrintableHeroStatus();
        userInterface.updateState(heroStatus, roomState);
    }

}
