package BoardManager;

public class BoardGenerator implements iBoardGenerator{

    @Override
    public void generateNewBoard() {
        iCell cells[][];
        cells = new iCell[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                cells[i][j] = new MovableCell();
            }
        }
    }

    @Override
    public void notifyNewBoard() {
        // TODO Auto-generated method stub
        
    }
    
}
