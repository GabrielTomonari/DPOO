package HeroManager.Collectables;

import HeroManager.iHeroManager;
import HeroManager.Status.iHeroStatus;

public class Banana implements iCollectable {

    @Override
    public void activate(iHeroStatus hero) {
        hero.restoreEnergy();
        hero.addFood();
    }

}
