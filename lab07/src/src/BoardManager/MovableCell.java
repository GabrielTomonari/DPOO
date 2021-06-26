package BoardManager;

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
    public void activateInteraction(iBoardController controller) {
        System.out.println("Interacting with a movable cell");

    }

}