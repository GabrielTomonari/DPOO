package HeroManager.Collectables;

import HeroManager.Status.iHeroStatus;

public class NullItem implements iCollectable {

    @Override
    public void activate(iHeroStatus hero) {
        return;
    }

}
