package HeroManager.Enemies;

import HeroManager.Status.iHeroStatus;

public class FireEnemy implements iEnemy {
    private int life;
    private int atack;
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

    @Override
    public boolean isDefeated() {
        return this.getLife() <= 0;
    }

    public String getImage() {
        return this.imgPath;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        System.out.println("Fire Enemy takes damage -- life at " + life);
        this.life = life;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }
}
