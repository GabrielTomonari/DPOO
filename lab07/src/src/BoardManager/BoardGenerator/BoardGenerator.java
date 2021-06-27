package BoardManager.BoardGenerator;

import java.util.concurrent.ThreadLocalRandom;

import BoardManager.Cells.CollectableCell;
import BoardManager.Cells.EmptyCell;
import BoardManager.Cells.EndFaseCell;
import BoardManager.Cells.ObstacleCell;
import BoardManager.Cells.iCell;
import HeroManager.Collectables.Banana;
import Utils.Position;

public class BoardGenerator extends NewBoardObservable implements iBoardGenerator {
    iCell[][] cells;

    public BoardGenerator(iCell[][] cells) {
        this.cells = cells;
    }

    @Override
    public void generateNewBoard() {
        this.fillWithEmptyCells();
        this.fillWithObstaclesCell();
        this.fillWithCollectableCells();
        this.fillWithEndFaseCell();
        notifyListeners(new NewBoardEvent());
    }

    @Override
    public void notifyListeners(NewBoardEvent event) {
        for (iNewBoardObserver observer : observers) {
            observer.update(event);
        }
    }

    private void fillWithEmptyCells() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                int randomIndex = 0;
                if (randomNum > 50) {
                    randomIndex = ThreadLocalRandom.current().nextInt(1, 5);
                }
                String path = "file:assets/img/movableCell/movableCell" + randomIndex + ".png";
                this.cells[i][j] = new EmptyCell(path, new Position(i, j));
            }
        }
    }

    private void fillWithObstaclesCell() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                int randomIndex = 0;
                if (randomNum > 70) {
                    randomIndex = ThreadLocalRandom.current().nextInt(1, 4);
                    String path = "file:assets/img/obstacleCell/Tree" + randomIndex + ".png";
                    this.cells[i][j] = new ObstacleCell(path, new Position(i, j));
                }
            }
        }
    }

    private void fillWithCollectableCells() {
        String pathToBanana = "file:assets/img/collectableCell/Banana.png";
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                if (randomNum > 95) {
                    this.cells[i][j] = new CollectableCell(pathToBanana, new Position(i, j), new Banana());
                }
            }
        }

    }

    private void fillWithEndFaseCell() {
        // todo fill with safe path
        this.cells[15][15] = new EndFaseCell(new Position(15, 15));
    }

}
