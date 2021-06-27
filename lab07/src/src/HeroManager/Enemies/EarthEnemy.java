package HeroManager.Enemies;

import HeroManager.Status.iHeroStatus;

public class EarthEnemy extends BaseEnemy {
    private String imgPath = "file:assets/img/enemies/EarthElemental.png";

    public EarthEnemy() {
        this.setLife(10);
        this.setAtack(1);
    }

    @Override
    public void dealDamageTo(iHeroStatus hero) {
        hero.decreaseHP(this.getAtack());
    }

    @Override
    public void receiveDamageFrom(iHeroStatus hero) {
        this.setLife(this.getLife() - hero.getAtackValue());
    }

    @Override
    public String getImage() {
        return this.imgPath;
    }

}
