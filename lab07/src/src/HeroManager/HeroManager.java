package HeroManager;

import BoardManager.iBoardManager;
import BoardManager.BoardGenerator.NewBoardEvent;
import HeroManager.Collectables.iCollectable;
import HeroManager.Status.HeroStatus;
import HeroManager.Status.iHeroStatus;
import Utils.Direction;
import Utils.Position;

public class HeroManager implements iHeroManager {
    // GameLogic
    private iBoardManager board;
    private iHeroStatus heroStatus;

    public HeroManager() {
        this.heroStatus = new HeroStatus();
    }

    @Override
    public boolean isAlive() {
        return this.heroStatus.isAlive();
    }

    @Override
    public PrintableHeroStatus expPrintableHeroStatus() {
        return this.heroStatus.expPrintableHeroStatus();
    }

    @Override
    public void update(Direction command) {
        this.heroStatus.setFacingDirection(command);

        Position positionToInteract;
        positionToInteract = new Position(this.heroStatus.getPosition(), command);
        this.board.interactWithCellAt(positionToInteract);
    }

    @Override
    public void update(Position positionToMove) {
        this.heroStatus.moveHero(positionToMove);
    }

    @Override
    public void connectBoard(iBoardManager board) {
        this.board = board;
    }

    @Override
    public void update(NewBoardEvent event) {
        this.placeHero();
    }

    @Override
    public void placeHero() {
        this.heroStatus.placeHero();
    }

    @Override
    public void update(iCollectable item) {
        item.activate(this.heroStatus);
    }

}
