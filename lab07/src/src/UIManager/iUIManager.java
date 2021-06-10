package UIManager;

import HeroManager.PrintableHeroStatus;
import RoomManager.PrintableRoomState;
import javafx.stage.Stage;

public interface iUIManager {
    public void renderState(PrintableHeroStatus heroStatus, PrintableRoomState roomState, Stage primaryStage);
}
