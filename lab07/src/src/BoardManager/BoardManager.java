package BoardManager;

import BoardManager.BoardGenerator.BoardGenerator;
import BoardManager.BoardGenerator.iBoardGenerator;
import BoardManager.BoardLogic.BoardLogicController;
import BoardManager.BoardLogic.iBoardLogicController;
import BoardManager.BoardState.BoardStateController;
import BoardManager.BoardState.iBoardStateController;
import BoardManager.BoardView.BoardView;
import BoardManager.BoardView.PrintableBoardState;
import BoardManager.BoardView.iBoardView;
import BoardManager.Cells.iCell;
import HeroManager.iHeroManager;
import UIManager.iUIManager;
import Utils.Position;

public class BoardManager implements iBoardManager {
    iCell cells[][] = new iCell[16][16];

    iUIManager ui;
    iHeroManager hero;
    iBoardGenerator boardGenerator;
    iBoardView boardView;
    iBoardStateController boardState;
    iBoardLogicController boardLogic;

    public BoardManager() {
        boardGenerator = new BoardGenerator(this.cells);
        boardGenerator.generateNewBoard();

        boardLogic = new BoardLogicController(boardGenerator);
        boardState = new BoardStateController(this.cells, this.boardLogic);
        boardView = new BoardView(this.cells);
    }

    @Override
    public PrintableBoardState exportPrintableBoardState() {
        return this.boardView.exportPrintableBoardState();
    }

    @Override
    public void interactWithCellAt(Position position) {
        this.boardState.interactWithCellAt(position);
    }

    @Override
    public void connectHero(iHeroManager hero) {
        this.hero = hero;
        this.boardLogic.addObserver(this.hero);
        this.boardGenerator.addObserver(this.hero);
    }

    @Override
    public void connectUI(iUIManager uiManager) {
        this.ui = uiManager;
        this.boardLogic.addObserver(this.ui);
        this.boardGenerator.addObserver(this.ui);
    }

}
