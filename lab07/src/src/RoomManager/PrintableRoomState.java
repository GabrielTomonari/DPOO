package RoomManager;

/**
 * PrintableRoomState
 */
public class PrintableRoomState {
    private int columnMax = 15;
    private int lineMax = 15;

    private String[][] images;
    private int lineCounter;
    private int columnCounter;
    private boolean hasFinished;

    public void appendImage() {

    }

    public void resetCounter() {
        this.lineCounter = 0;
        this.columnCounter = 0;
        hasFinished = false;
    }

    public int currentLine() {
        return lineCounter;
    }

    public int currentColumn() {
        return columnCounter;
    }

    public String getCurrentImage() {
        return images[lineCounter][columnCounter];
    }

    public void changeToNextImage() {
        columnCounter++;
        if (columnCounter > columnMax) {
            columnCounter = 0;
            lineCounter++;
            if (lineCounter > lineMax) {
                hasFinished = true;
            }
        }
    }

    public boolean shouldPrintNext() {
        return hasFinished;
    }
}