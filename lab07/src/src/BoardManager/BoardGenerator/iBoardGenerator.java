package BoardManager.BoardGenerator;

import BoardManager.Cells.iCell;

public interface iBoardGenerator {

    public iCell[][] generateNewBoard();

    public void notifyNewBoard();
}
