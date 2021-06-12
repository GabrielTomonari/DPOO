package RoomManager;

public class FakeRoomManager implements iRoomManager {

    @Override
    public void generateNewRoom() {
        // TODO Auto-generated method stub

    }

    @Override
    public PrintableRoomState expPrintableRoomState() {
        PrintableRoomState state = new PrintableRoomState();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                String num = (i % 2 == 0) ? "1" : "2";
                state.appendImage(i, j, "file:assets/img/Tree" + num + ".png");
            }
        }

        return state;
    }

}
