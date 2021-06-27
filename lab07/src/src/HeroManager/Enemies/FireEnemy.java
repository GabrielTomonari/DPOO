package HeroManager.Enemies;

import HeroManager.Status.iHeroStatus;

public class FireEnemy extends BaseEnemy {
    private String imgPath = "file:assets/img/enemies/FireElemental.png";

    public FireEnemy() {
        this.setLife(5);
        this.setAtack(2);
    }

    @Override
    public void dealDamageTo(iHeroStatus hero) {
        hero.decreaseHP(this.getAtack());
    }

    @Override
    public void receiveDamageFrom(iHeroStatus hero) {
        this.setLife(this.getLife() - hero.getAtackValue());
    }

    public String getImage() {
        return this.imgPath;
    }
}
