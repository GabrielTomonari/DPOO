package BoardManager;

import Utils.Position;

public class BoardStateController implements iBoardStateController {
    iCell cells[][];
    iBoardLogicController boardLogic;

    public BoardStateController(iCell[][] cells, iBoardLogicController boardLogic) {
        this.cells = cells;
        this.boardLogic = boardLogic;
    }

    @Override
    public void interactWithCellAt(Position position) {
        try {
            this.cells[position.line][position.column].activateInteraction(this.boardLogic);
        } catch (ArrayIndexOutOfBoundsException e) {
            ObstacleCell tempo = new ObstacleCell();
            tempo.activateInteraction(this.boardLogic);
        } catch (Exception e) {
            throw e;
        }
    }
}
