package UIManager;

import HeroManager.iHeroManConsumer;
import BoardManager.iBoardManConsumer;
import BoardManager.iMoveObserver;
import javafx.stage.Stage;

public interface iUIManager extends iHeroManConsumer, iBoardManConsumer, iMoveObserver {

    public void updateState();

    public void setStage(Stage stage);

    public void render();
}
