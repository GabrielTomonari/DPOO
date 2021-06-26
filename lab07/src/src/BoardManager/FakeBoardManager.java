package BoardManager;

import Utils.Position;

public class FakeBoardManager implements iBoardStateManager {

    @Override
    public iCell[][] generateNewBoard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void notifyNewBoard() {
        // TODO Auto-generated method stub

    }

    @Override
    public PrintableBoardState exportPrintableBoardState() {
        PrintableBoardState state = new PrintableBoardState();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                String num = (i % 2 == 0) ? "1" : "2";
                state.appendImage(i, j, "file:assets/img/Tree" + num + ".png");
            }
        }

        return state;
    }

    @Override
    public void interactWithCellAt(Position position) {
        // TODO Auto-generated method stub

    }

}
