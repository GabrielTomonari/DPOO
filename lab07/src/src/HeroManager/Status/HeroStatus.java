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
    private int initialAtack = 1;

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
    private int atackValue;
    private GeneType[] genes;
    private int geneCounter;

    public HeroStatus() {
        this.maxHP = this.initialHP;
        this.currentHP = this.maxHP;
        this.maxXp = this.initialMaxXp;
        this.currentXp = 0;
        this.maxEnergy = this.initialEnergy;
        this.currentEnergy = this.maxEnergy;
        this.food = 0;
        this.currentLevel = 0;
        this.setAtackValue(this.initialAtack);
        this.geneCounter = 0;
        this.genes = new GeneType[3];
    }

    public int getAtackValue() {
        return atackValue;
    }

    private void setAtackValue(int atackValue) {
        this.atackValue = atackValue;
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

    public void decreaseHP(int damage) {
        if (this.currentHP - damage > 0) {
            this.currentHP -= damage;
        } else {
            this.currentHP = 0;
            System.out.println("hero is dead");
        }
    }

    public void decreaseEnergy(int damage) {
        if (this.currentEnergy - damage > 0) {
            this.currentEnergy -= damage;
        } else {
            this.currentEnergy = 0;
            decreaseHP(1);
        }
    }

    public void restoreEnergy() {
        this.currentEnergy = this.maxEnergy;
    }

    public void moveHero(Position position) {
        System.out.println(position.line + ", " + position.column);
        this.decreaseEnergy(1);
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
        status.hasFireGene = this.hasGene(GeneType.Fire);
        status.hasWaterGene = this.hasGene(GeneType.Water);
        status.hasEarthGene = this.hasGene(GeneType.Earth);

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

    @Override
    public boolean hasGene(GeneType gene) {
        for (GeneType heroGene : genes) {
            if (gene == heroGene) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addGene(GeneType gene) {
        switch (gene) {
            case Fire:
                // increase attack
                break;
            case Water:
                // increase energy
                break;
            case Earth:
                // increase life
                break;
            default:
                break;
        }
        if (!hasGene(gene)) {
            this.genes[geneCounter] = gene;
            this.geneCounter++;
        }
    }
}
