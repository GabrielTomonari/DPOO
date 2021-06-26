package BoardManager;

import Utils.Position;

public class BoardStateManager implements iBoardStateManager {
    iCell cells[][];
    iBoardGenerator boardGenerator;

    public BoardStateManager() {
        boardGenerator = new BoardGenerator();
        this.cells = boardGenerator.generateNewBoard();
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
        try {
            this.cells[position.line][position.column].activateInteraction(this);
        } catch (ArrayIndexOutOfBoundsException e) {
            ObstacleCell tempo = new ObstacleCell();
            tempo.activateInteraction(this);
        } catch (Exception e) {
            throw e;
        }
    }

}
