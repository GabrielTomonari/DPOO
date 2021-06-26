package HeroManager;

import UIManager.iCommandObserver;

public interface iHeroManager extends iCommandObserver {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
