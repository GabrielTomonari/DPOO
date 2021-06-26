package BoardManager;

import Utils.Position;

public class BoardController extends MoveObservable implements iBoardController {
    iCell cells[][];

    public BoardController(iCell[][] cells) {
        this.cells = cells;
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

    @Override
    public void notifyMovement(Position position) {
        System.out.println(observers.size());
        for (iMoveObserver observer : observers) {
            observer.update(position);
        }
    }

}
