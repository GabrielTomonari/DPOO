package HeroManager;

import BoardManager.iBoardManConsumer;
import UIManager.iCommandObserver;

public interface iHeroManager extends iCommandObserver, iBoardManConsumer {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
