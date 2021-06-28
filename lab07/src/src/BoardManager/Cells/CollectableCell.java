package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import HeroManager.Collectables.NullItem;
import HeroManager.Collectables.iCollectable;
import Utils.Position;

public class CollectableCell extends MovableCell {
    iCollectable item;

    public CollectableCell(String imagePath, Position position, iCollectable item) {
        super(imagePath, position);
        this.item = item;
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        controller.notifyItem(this.item);
        this.imagePath = "file:assets/img/movableCell/movableCell0.png";
        this.item = new NullItem();
        super.activateInteraction(controller);
    }

}
