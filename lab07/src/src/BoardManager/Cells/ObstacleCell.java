package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;

public class ObstacleCell implements iCell {
    String imgPath;

    public ObstacleCell(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
    }

    @Override
    public String getCellImage() {
        return this.imgPath;
    }

}