package HeroManager;

import BoardManager.iBoardManConsumer;
import BoardManager.BoardGenerator.iNewBoardObserver;
import BoardManager.BoardLogic.iMoveObserver;
import HeroManager.Collectables.iCollectableObserver;
import HeroManager.Enemies.iCombatObserver;
import UIManager.InterfaceController.iDirectionObserver;

public interface iHeroManager extends iDirectionObserver, iMoveObserver, iBoardManConsumer, iNewBoardObserver,
        iCollectableObserver, iCombatObserver {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
