package BoardManager;

public interface iBoardGenerator {
    
    public iCell[][] generateNewBoard();
    public void notifyNewBoard();
}
