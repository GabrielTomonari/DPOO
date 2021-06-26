package BoardManager;

import Utils.Position;

public interface iMoveObserver {
    void update(Position positionToMove);
}
