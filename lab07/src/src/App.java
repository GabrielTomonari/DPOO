/**
 ** App
 */
public class App {

    public static void main(String[] args) {
        iRoomManager room;
        iUIManager userInterface;
        iHeroManager hero;

        room.generateRoomNewRoom();
        hero.placeHero();
        while(hero.isAlive()){
            PrintableRoomState roomState = room.exportPrintableState();
            PrintableHeroStatus heroStatus = hero.exportPrintableStatus();
            userInterface.renderState(roomState, heroStatus);
        }
    }
}
