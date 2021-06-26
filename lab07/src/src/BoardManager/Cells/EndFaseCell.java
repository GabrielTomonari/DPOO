package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;

/**
 * EndFaseCell
 */
public class EndFaseCell implements iCell {
    String imagePath = "file:assets/img/portalCell/portal.png";

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        controller.generateNewBoard();
        controller.replaceHero();
    }

    @Override
    public String getCellImage() {
        return this.imagePath;
    }

}