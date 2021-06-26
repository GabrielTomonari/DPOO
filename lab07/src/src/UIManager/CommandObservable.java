package UIManager;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandObservable {
    protected List<iCommandObserver> observers = new ArrayList<>();

    public void addObserver(iCommandObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(iCommandObserver observer) {
        this.observers.remove(observer);
    }

    abstract protected void notifyCommand();
}
