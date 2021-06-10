package RoomManager;

/**
 * PrintableRoomState
 */
public class PrintableRoomState {
    private String[][] images;
    private int lineCounter;
    private int columnCounter;

    public void appendImage() {

    }

    public void resetCounter() {
        this.lineCounter = 0;
        this.columnCounter = 0;
    }

    public String getImage() {
        return images[lineCounter][columnCounter];
    }

    public void nextImage() {
        if (this.columnCounter > 15) {
            this.columnCounter = 0;
            if (this.lineCounter < 15) {
                this.lineCounter++;
            }
        }
    }
}