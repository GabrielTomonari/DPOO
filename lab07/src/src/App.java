import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import BoardManager.PrintableRoomState;
import BoardManager.iBoardManager;
import UIManager.iUIManager;

/**
 ** App
 */
public class App {

    public static void main(String[] args) {
        iBoardManager room;
        iUIManager userInterface;
        iHeroManager hero;

        room.generateNewRoom();
        hero.placeHero();
        while (hero.isAlive()) {
            PrintableRoomState roomState = room.expPrintableRoomState();
            PrintableHeroStatus heroStatus = hero.expPrintableHeroStatus();
            userInterface.renderState(heroStatus, roomState);
        }
    }
}
