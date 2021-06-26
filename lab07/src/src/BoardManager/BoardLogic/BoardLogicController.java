package BoardManager.BoardLogic;

import BoardManager.BoardGenerator.iBoardGenerator;
import Utils.Position;

public class BoardLogicController extends PositionObservable implements iBoardLogicController {
    iBoardGenerator boardGenerator;

    public BoardLogicController(iBoardGenerator boardGenerator) {
        this.boardGenerator = boardGenerator;
    }

    @Override
    public void notifyListeners(Position position) {
        for (iMoveObserver observer : observers) {
            observer.update(position);
        }
    }

    @Override
    public void generateNewBoard() {
        this.boardGenerator.generateNewBoard();
    }

    @Override
    public void replaceHero() {
        // TODO Auto-generated method stub

    }

}
