package HeroManager;

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

        return heroStatus;
    }

    @Override
    public void placeHero() {
        // TODO Auto-generated method stub

    }

}
