package UIManager;

import HeroManager.iHeroManConsumer;
import BoardManager.iBoardManConsumer;
import BoardManager.BoardGenerator.iNewBoardObserver;
import BoardManager.BoardLogic.iMoveObserver;
import javafx.stage.Stage;

public interface iUIManager extends iHeroManConsumer, iBoardManConsumer, iMoveObserver, iNewBoardObserver {

    public void updateState();

    public void setStage(Stage stage);

    public void render();
}
