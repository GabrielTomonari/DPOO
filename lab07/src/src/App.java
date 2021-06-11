import HeroManager.FakeHeroManager;
import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import RoomManager.FakeRoomManager;
import RoomManager.PrintableRoomState;
import RoomManager.iRoomManager;
import UIManager.GameTimer;
import UIManager.UIManager;
import UIManager.iUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 ** App
 */
public class App extends Application {
    iRoomManager room = new FakeRoomManager();
    iUIManager userInterface = new UIManager();
    iHeroManager hero = new FakeHeroManager();
    GameTimer timer = new GameTimer();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private void setUp(Stage primaryStage) {
        // GameLogic SetUp
        this.room.generateNewRoom();
        this.hero.placeHero();
        this.userInterface.setStage(primaryStage);

        // conect the ui with timer so it render on every new frame
        this.timer.connect(userInterface);
        this.timer.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setUp(primaryStage);
        PrintableRoomState roomState = this.room.expPrintableRoomState();
        PrintableHeroStatus heroStatus = this.hero.expPrintableHeroStatus();
        userInterface.updateState(heroStatus, roomState);
    }

}
