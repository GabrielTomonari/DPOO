package UIManager;

import HeroManager.PrintableHeroStatus;
import RoomManager.PrintableRoomState;

public interface iUIManager {
    public void renderState(PrintableHeroStatus heroStatus, PrintableRoomState roomState);
}
