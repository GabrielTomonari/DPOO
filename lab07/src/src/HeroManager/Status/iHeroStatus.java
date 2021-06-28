package HeroManager.Status;

import HeroManager.PrintableHeroStatus;
import Utils.Direction;
import Utils.Position;

public interface iHeroStatus {
    public boolean isAlive();

    public void placeHero();

    public void decreaseHP();

    public void decreaseEnergy();

    public void restoreEnergy();

    public void addFood();

    public void moveHero(Position position);

    public void setFacingDirection(Direction direction);

    public Position getPosition();

    public PrintableHeroStatus expPrintableHeroStatus();
}
