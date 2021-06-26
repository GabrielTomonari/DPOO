package BoardManager;

import java.util.ArrayList;
import java.util.List;

import Utils.Position;

public abstract class MoveObservable {
    protected List<iMoveObserver> observers = new ArrayList<>();

    public void addObserver(iMoveObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(iMoveObserver observer) {
        this.observers.remove(observer);
    }

    abstract public void notifyMovement(Position position);
}
