package BoardManager;

public class BoardStateManager{
    iCell cells[][];

    BoardStateManager(){
        cells = new iCell[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                cells[i][j] = new MovableCell();
            }
        }
    }

    
}
