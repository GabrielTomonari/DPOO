package BoardManager.BoardLogic;

public interface iBoardLogicController extends iMoveObservable {
    public void generateNewBoard();

    public void replaceHero();
}
