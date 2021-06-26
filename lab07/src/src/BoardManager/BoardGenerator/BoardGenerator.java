package BoardManager.BoardGenerator;

import java.util.concurrent.ThreadLocalRandom;

import BoardManager.Cells.EndFaseCell;
import BoardManager.Cells.MovableCell;
import BoardManager.Cells.iCell;
import Utils.Position;

public class BoardGenerator extends NewBoardObservable implements iBoardGenerator {
    iCell[][] cells;

    public BoardGenerator(iCell[][] cells) {
        this.cells = cells;
    }

    @Override
    public void generateNewBoard() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                int randomIndex = 0;
                if (randomNum > 50) {
                    randomIndex = ThreadLocalRandom.current().nextInt(1, 5);
                }
                String path = "file:assets/img/movableCell/movableCell" + randomIndex + ".png";
                this.cells[i][j] = new MovableCell(path, new Position(i, j));
            }
        }

        this.cells[15][0] = new EndFaseCell();
        notifyListeners(new NewBoardEvent());
    }

    @Override
    public void notifyListeners(NewBoardEvent event) {
        for (iNewBoardObserver observer : observers) {
            observer.update(event);
        }
    }

}
