package HeroManager;

import Utils.Direction;
import Utils.Position;

public class HeroManager implements iHeroManager {
    // Config and Constants
    private Position initialPos = new Position(0, 0);
    private int initialHP = 10;
    private int initialEnergy = 10;

    // hero Variables
    private Position position;
    public Direction facingDirection;
    private int maxHP;
    private int currentHP;
    private int xp;
    private int energy;
    private int food;

    public HeroManager() {
        this.maxHP = this.initialHP;
        this.currentHP = this.maxHP;
        this.xp = 0;
        this.energy = this.initialEnergy;
        this.food = 0;
    }

    @Override
    public boolean isAlive() {
        return this.currentHP > 0;
    }

    @Override
    public PrintableHeroStatus expPrintableHeroStatus() {
        PrintableHeroStatus status = new PrintableHeroStatus();

        status.position = this.position;
        status.facingDirection = this.facingDirection;
        status.currentHP = this.currentHP;
        status.maxHP = this.maxHP;
        status.currentXp = this.xp;
        status.currentEnergy = this.energy;
        status.food = this.food;

        return status;
    }

    @Override
    public void placeHero() {
        this.position = this.initialPos;
        this.facingDirection = Direction.Down;
    }

}
