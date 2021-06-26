package HeroManager;

import BoardManager.iBoardManConsumer;
import BoardManager.BoardLogic.iMoveObserver;
import UIManager.InterfaceController.iDirectionObserver;

public interface iHeroManager extends iDirectionObserver, iMoveObserver, iBoardManConsumer {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
