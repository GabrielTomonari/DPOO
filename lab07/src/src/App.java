import HeroManager.FakeHeroManager;
import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import RoomManager.FakeRoomManager;
import RoomManager.PrintableRoomState;
import RoomManager.iRoomManager;
import UIManager.UIManager;
import UIManager.iUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 ** App
 */
public class App extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        iRoomManager room = new FakeRoomManager();
        iUIManager userInterface = new UIManager();
        iHeroManager hero = new FakeHeroManager();

        room.generateNewRoom();
        hero.placeHero();
        while (hero.isAlive()) {
            PrintableRoomState roomState = room.expPrintableRoomState();
            PrintableHeroStatus heroStatus = hero.expPrintableHeroStatus();
            userInterface.renderState(heroStatus, roomState, primaryStage);
        }
    }

}
