import BoardManager.PrintableBoardState;
import BoardManager.iBoardStateManager;
import BoardManager.BoardStateManager;
import HeroManager.FakeHeroManager;
import HeroManager.HeroManager;
import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import UIManager.UIManager;
import UIManager.iUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 ** App
 */
public class App extends Application {
    iBoardStateManager room = new BoardStateManager();
    iUIManager userInterface = new UIManager();
    iHeroManager hero = new HeroManager();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private void setUp(Stage primaryStage) {
        // GameLogic SetUp
        this.room.generateNewBoard();
        this.hero.placeHero();
        this.userInterface.setStage(primaryStage);
        this.userInterface.connectBoard(this.room);
        this.userInterface.connectHero(this.hero);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setUp(primaryStage);
        userInterface.updateState();
    }

}
