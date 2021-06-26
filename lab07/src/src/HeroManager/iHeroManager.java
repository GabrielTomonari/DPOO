package HeroManager;

import BoardManager.iBoardManConsumer;
import BoardManager.iMoveObserver;
import UIManager.iDirectionObserver;

public interface iHeroManager extends iDirectionObserver, iMoveObserver, iBoardManConsumer {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
