package BoardManager;

import BoardManager.BoardGenerator.iBoardGenerator;
import BoardManager.BoardState.iBoardStateController;
import BoardManager.BoardView.iBoardView;
import HeroManager.iHeroManConsumer;
import UIManager.iUIManConsumer;

public interface iBoardStateManager
                extends iBoardGenerator, iBoardView, iBoardStateController, iHeroManConsumer, iUIManConsumer {

}
