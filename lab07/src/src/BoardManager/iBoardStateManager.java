package BoardManager;

import HeroManager.iHeroManConsumer;
import UIManager.iUIManConsumer;

public interface iBoardStateManager
        extends iBoardGenerator, iBoardView, iBoardController, iHeroManConsumer, iUIManConsumer {

}
