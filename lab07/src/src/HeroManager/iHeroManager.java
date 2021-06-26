package HeroManager;

import BoardManager.iBoardManConsumer;
import BoardManager.BoardGenerator.iNewBoardObserver;
import BoardManager.BoardLogic.iMoveObserver;
import UIManager.InterfaceController.iDirectionObserver;

public interface iHeroManager extends iDirectionObserver, iMoveObserver, iBoardManConsumer, iNewBoardObserver {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
