package HeroManager.Enemies;

import HeroManager.Status.iHeroStatus;

public class WaterEnemy extends BaseEnemy {
    String imgPath = "file:assets/img/enemies/WaterElemental.png";

    public WaterEnemy() {
        this.setAtack(1);
        this.setLife(5);
    }

    @Override
    public void dealDamageTo(iHeroStatus hero) {
        hero.decreaseHP(this.getAtack());
        hero.decreaseEnergy(this.getAtack());
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
