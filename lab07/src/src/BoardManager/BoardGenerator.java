package BoardManager;
import java.util.concurrent.ThreadLocalRandom;

public class BoardGenerator implements iBoardGenerator{

    @Override
    public iCell[][] generateNewBoard() {
        iCell cells[][];
        cells = new iCell[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                int randomIndex = 0;
                if (randomNum > 50) {
                    randomIndex = ThreadLocalRandom.current().nextInt(1, 5);
                }
                String path = "file:assets/img/movableCell/movableCell"+randomIndex+".png";
                cells[i][j] = new MovableCell(path);
            }
        }
        return cells;
    }

    @Override
    public void notifyNewBoard() {
        // TODO Auto-generated method stub
        
    }
    
}
