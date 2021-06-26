package BoardManager;

import HeroManager.iHeroManager;
import UIManager.iUIManConsumer;
import UIManager.iUIManager;
import Utils.Position;

public class BoardStateManager implements iBoardStateManager {
    iCell cells[][];
    iUIManager ui;
    iHeroManager hero;
    iBoardGenerator boardGenerator;
    iBoardStateController boardState;
    iBoardLogicController boardLogic;

    public BoardStateManager() {
        boardGenerator = new BoardGenerator();
        this.cells = boardGenerator.generateNewBoard();

        boardLogic = new BoardLogicController();
        boardState = new BoardStateController(this.cells, this.boardLogic);

    }

    @Override
    public iCell[][] generateNewBoard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void notifyNewBoard() {
        // TODO Auto-generated method stub

    }

    @Override
    public PrintableBoardState exportPrintableBoardState() {
        PrintableBoardState printableState = new PrintableBoardState();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                printableState.appendImage(i, j, this.cells[i][j].getCellImage());
            }
        }
        return printableState;
    }

    @Override
    public void interactWithCellAt(Position position) {
        this.boardState.interactWithCellAt(position);
    }

    @Override
    public void connectHero(iHeroManager hero) {
        this.hero = hero;
        this.boardLogic.addObserver(this.hero);
    }

    @Override
    public void connectUI(iUIManager uiManager) {
        this.ui = uiManager;
        this.boardLogic.addObserver(this.ui);
    }

}
