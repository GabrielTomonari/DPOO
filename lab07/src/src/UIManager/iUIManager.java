package UIManager;

import HeroManager.PrintableHeroStatus;
import BoardManager.PrintableBoardState;
import javafx.stage.Stage;

public interface iUIManager {

    public void updateState(PrintableHeroStatus heroStatus, PrintableBoardState roomState);

    public void setStage(Stage stage);

    public void render();
}
