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
    public void activateInteraction() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCellImage() {
        return this.imagePath;
    }

}