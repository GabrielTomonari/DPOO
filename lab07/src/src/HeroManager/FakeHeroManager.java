package HeroManager;

import BoardManager.iBoardStateManager;
import UIManager.iCommand;
import Utils.Direction;
import Utils.Position;

public class FakeHeroManager implements iHeroManager {

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public PrintableHeroStatus expPrintableHeroStatus() {
        PrintableHeroStatus heroStatus = new PrintableHeroStatus();
        heroStatus.position = new Position(15, 0);
        heroStatus.facingDirection = Direction.Down;
        heroStatus.food = 10;
        heroStatus.maxHP = 200;
        heroStatus.currentHP = 100;
        heroStatus.currentEnergy = 10;
        heroStatus.maxEnergy = 15;
        heroStatus.currentXp = 100;
        heroStatus.maxXp = 1000;
        heroStatus.currentLevel = 5;

        return heroStatus;
    }

    @Override
    public void placeHero() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(iCommand command) {
        // TODO Auto-generated method stub

    }

    @Override
    public void connectBoard(iBoardStateManager board) {
        // TODO Auto-generated method stub

    }

}
