package BoardManager;

public class BoardStateManager {
    Cell cells[][];

    BoardStateManager(){
        cells = new Cell[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    
}
