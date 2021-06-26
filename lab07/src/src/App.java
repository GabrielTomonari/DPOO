import BoardManager.iBoardStateManager;
import BoardManager.BoardStateManager;
import HeroManager.HeroManager;
import HeroManager.iHeroManager;
import UIManager.UIManager;
import UIManager.iUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 ** App
 */
public class App extends Application {
    iBoardStateManager board = new BoardStateManager();
    iUIManager userInterface = new UIManager();
    iHeroManager hero = new HeroManager();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private void setUp(Stage primaryStage) {
        // GameLogic SetUp
        this.board.generateNewBoard();
        this.hero.placeHero();
        this.userInterface.setStage(primaryStage);
        this.userInterface.connectBoard(this.board);
        this.userInterface.connectHero(this.hero);
        this.hero.connectBoard(this.board);
        this.board.connectHero(this.hero);
        this.board.connectUI(this.userInterface);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setUp(primaryStage);
        userInterface.updateState();
    }

}
