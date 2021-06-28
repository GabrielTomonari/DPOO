package BoardManager.BoardLogic;

import HeroManager.Collectables.iCollectable;

public interface iBoardLogicController extends iMoveObservable {
    public void generateNewBoard();

    public void replaceHero();

    public void notifyItem(iCollectable info);
}
