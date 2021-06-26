package UIManager;

import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManConsumer;
import BoardManager.PrintableBoardState;
import BoardManager.iBoardManConsumer;
import javafx.stage.Stage;

public interface iUIManager extends iHeroManConsumer, iBoardManConsumer {

    public void updateState();

    public void setStage(Stage stage);

    public void render();
}
