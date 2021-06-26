package HeroManager;

import UIManager.iCommand;
import Utils.Direction;
import Utils.Position;

public class HeroManager implements iHeroManager {
    // Config and Constants
    private Position initialPos = new Position(0, 0);
    private int initialHP = 10;
    private int initialEnergy = 10;
    private int initialMaxXp = 10;

    // hero Variables
    private Position position;
    public Direction facingDirection;
    private int maxHP;
    private int currentHP;
    private int maxXp;
    private int currentXp;
    private int maxEnergy;
    private int currentEnergy;
    private int food;
    private int currentLevel;

    public HeroManager() {
        this.maxHP = this.initialHP;
        this.currentHP = this.maxHP;
        this.maxXp = this.initialMaxXp;
        this.currentXp = 0;
        this.maxEnergy = this.initialEnergy;
        this.currentEnergy = this.maxEnergy;
        this.food = 0;
        this.currentLevel = 0;
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
        status.maxXp = this.maxXp;
        status.currentXp = this.currentXp;
        status.maxEnergy = this.maxEnergy;
        status.currentEnergy = this.currentEnergy;
        status.food = this.food;
        status.currentLevel = this.currentLevel;

        return status;
    }

    @Override
    public void placeHero() {
        this.position = this.initialPos;
        this.facingDirection = Direction.Down;
        this.currentLevel++;
    }

    @Override
    public void update(iCommand command) {
        switch (command.getInfo()) {
            case Up:
                System.out.println("Subindo");
                break;
            case Down:
                System.out.println("Descendo");
                break;
            case Left:
                System.out.println("Direita");
                break;
            case Rigth:
                System.out.println("Esquerda");
                break;
            default:
                break;
        }
    }

}
