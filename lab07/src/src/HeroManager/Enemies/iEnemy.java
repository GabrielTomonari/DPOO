package HeroManager.Enemies;

import HeroManager.Status.iHeroStatus;

public interface iEnemy {
    public void dealDamageTo(iHeroStatus hero);

    public void receiveDamageFrom(iHeroStatus hero);

    public boolean isDefeated();
}
