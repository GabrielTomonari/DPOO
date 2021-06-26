package HeroManager;

import BoardManager.iBoardManager;
import Utils.Direction;
import Utils.Position;

public class HeroManager implements iHeroManager {
    // Config and Constants
    private Position initialPos = new Position(0, 0);
    private int initialHP = 10;
    private int initialEnergy = 10;
    private int initialMaxXp = 10;

    // GameLogic
    private iBoardManager board;

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

    public void moveHero(Position position) {
        this.position = position;
    }

    @Override
    public void update(Direction command) {
        Position positionToInteract;

        positionToInteract = new Position(this.position, command);
        this.board.interactWithCellAt(positionToInteract);
    }

    @Override
    public void update(Position positionToMove) {
        this.moveHero(positionToMove);
    }

    @Override
    public void connectBoard(iBoardManager board) {
        this.board = board;
    }

}
