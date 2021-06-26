package BoardManager.BoardLogic;

import Utils.Position;

public class BoardLogicController extends PositionObservable implements iBoardLogicController {

    @Override
    public void notifyListeners(Position position) {
        for (iMoveObserver observer : observers) {
            observer.update(position);
        }
    }

}
