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
    BoardController boardController;

    public BoardStateManager() {
        boardGenerator = new BoardGenerator();
        this.cells = boardGenerator.generateNewBoard();

        boardController = new BoardController(this.cells);
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
        this.boardController.interactWithCellAt(position);
    }

    @Override
    public void connectHero(iHeroManager hero) {
        this.hero = hero;
        this.boardController.addObserver(this.hero);
    }

    @Override
    public void connectUI(iUIManager uiManager) {
        this.ui = uiManager;
        this.boardController.addObserver(this.ui);
    }

}
