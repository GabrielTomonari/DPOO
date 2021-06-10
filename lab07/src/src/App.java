import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import RoomManager.PrintableRoomState;
import RoomManager.iRoomManager;
import UIManager.iUIManager;

/**
 ** App
 */
public class App {

    public static void main(String[] args) {
        iRoomManager room;
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
