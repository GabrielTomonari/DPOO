package BoardManager.BoardLogic;

import BoardManager.BoardGenerator.iBoardGenerator;
import HeroManager.Collectables.iCollectable;
import Utils.Position;

public class BoardLogicController extends PositionObservable implements iBoardLogicController {
    iBoardGenerator boardGenerator;
    iBoardItensLogic boardItems;

    public BoardLogicController(iBoardGenerator boardGenerator, iBoardItensLogic boardItems) {
        this.boardGenerator = boardGenerator;
        this.boardItems = boardItems;
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

    @Override
    public void notifyItem(iCollectable info) {
        this.boardItems.notifyListeners(info);

    }

}
