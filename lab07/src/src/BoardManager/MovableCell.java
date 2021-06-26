package BoardManager;

import Utils.Position;

/**
 * MovableCell
 */
public class MovableCell implements iCell {
    String imagePath;

    MovableCell(String path) {
        this.imagePath = path;
    }

    @Override
    public String getCellImage() {
        return this.imagePath;
    }

    @Override
    public void activateInteraction(BoardController controller) {
        System.out.println("movind hero");
        controller.notifyMovement(new Position(5, 5));
    }

}