package UIManager;

import HeroManager.PrintableHeroStatus;
import RoomManager.PrintableRoomState;
import javafx.stage.Stage;

public interface iUIManager {

    public void updateState(PrintableHeroStatus heroStatus, PrintableRoomState roomState);

    public void setStage(Stage stage);

    public void render();
}
