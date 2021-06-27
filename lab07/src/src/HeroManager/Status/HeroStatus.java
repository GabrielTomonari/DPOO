package HeroManager.Status;

import HeroManager.PrintableHeroStatus;
import Utils.Direction;
import Utils.Position;

public class HeroStatus implements iHeroStatus {
    // Config and Constants
    private Position initialPos = new Position(0, 0);
    private int initialHP = 10;
    private int initialEnergy = 10;
    private int initialMaxXp = 10;

    // hero Variables
    private Position position;
    private Direction facingDirection;
    private int maxHP;
    private int currentHP;
    private int maxXp;
    private int currentXp;
    private int maxEnergy;
    private int currentEnergy;
    private int food;
    private int currentLevel;

    public HeroStatus() {
        this.maxHP = this.initialHP;
        this.currentHP = this.maxHP;
        this.maxXp = this.initialMaxXp;
        this.currentXp = 0;
        this.maxEnergy = this.initialEnergy;
        this.currentEnergy = this.maxEnergy;
        this.food = 0;
        this.currentLevel = 0;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public boolean isAlive() {
        return this.currentHP > 0;
    }

    @Override
    public void placeHero() {
        this.setPosition(this.initialPos);
        this.setFacingDirection(Direction.Down);
        this.currentLevel++;
    }

    public void decreaseHP() {
        if (this.currentHP > 1) {
            this.currentHP--;
        } else {
            this.currentHP = 0;
            System.out.println("hero is dead");
        }
    }

    public void decreaseEnergy() {
        if (this.currentEnergy > 0) {
            this.currentEnergy--;
        } else {
            decreaseHP();
        }
    }

    public void restoreEnergy() {
        this.currentEnergy = this.maxEnergy;
    }

    public void moveHero(Position position) {
        System.out.println(position.line + ", " + position.column);
        this.decreaseEnergy();
        this.setPosition(position);
    }

    @Override
    public PrintableHeroStatus expPrintableHeroStatus() {
        PrintableHeroStatus status = new PrintableHeroStatus();

        status.position = this.position;
        status.facingDirection = this.facingDirection;
        status.currentHP = this.currentHP;
        status.maxHP = this.maxHP;
        status.maxXp = this.maxXp;
        status.currentXp = this.currentXp;
        status.maxEnergy = this.maxEnergy;
        status.currentEnergy = this.currentEnergy;
        status.food = this.food;
        status.currentLevel = this.currentLevel;

        return status;
    }

    @Override
    public void addFood() {
        this.food++;
        if (food == 11) {
            this.food = 1;
            this.maxHP += 5;
            this.currentHP += 5;
        }
    }
}
