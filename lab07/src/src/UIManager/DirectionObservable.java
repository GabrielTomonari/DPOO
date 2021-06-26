package UIManager;

import java.util.ArrayList;
import java.util.List;

public abstract class DirectionObservable {
    protected List<iDirectionObserver> observers = new ArrayList<>();

    public void addObserver(iDirectionObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(iDirectionObserver observer) {
        this.observers.remove(observer);
    }

    abstract protected void notifyCommand();
}
