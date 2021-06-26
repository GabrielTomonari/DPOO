package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import Utils.Position;

/**
 * MovableCell
 */
public class MovableCell implements iCell {
    String imagePath;
    Position position;

    public MovableCell(String path, Position position) {
        this.imagePath = path;
        this.position = position;
    }

    @Override
    public String getCellImage() {
        return this.imagePath;
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        controller.notifyListeners(this.position);
    }

}