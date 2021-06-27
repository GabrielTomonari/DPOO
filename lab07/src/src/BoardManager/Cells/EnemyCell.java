package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import HeroManager.Collectables.Banana;
import HeroManager.Collectables.NullItem;
import HeroManager.Enemies.iEnemy;
import Utils.Position;

public class EnemyCell extends CollectableCell implements iCell {
    iEnemy enemy;

    public EnemyCell(String imagePath, Position position, iEnemy enemy) {
        super(imagePath, position, new NullItem());
        this.enemy = enemy;
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        if (!enemy.isDefeated()) {
            controller.notifyCombat(this.enemy);
            if (enemy.isDefeated()) {
                // TODO adicionar chance de gene
                this.item = new Banana();
                this.imagePath = "file:assets/img/collectableCell/Banana.png";
            }
        } else {
            super.activateInteraction(controller);
        }

    }

}