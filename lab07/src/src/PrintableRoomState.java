/**
 * PrintableRoomState
 */
public class PrintableRoomState {
    private String[][] images;
    private int lineCounter;
    private int columnCounter;

    public appendImage() {
        
    }

    public resetCounter() {
        this.lineCounter = 0;
        this.columnCounter = 0;
    }

    public getImage(){
        return images[lineCounter][columnCounter];
    }

    public nextImage(){
        if(this.columnCounter > 15){
            this.columnCounter = 0;
            if (this.lineCounter < 15) {
                this.lineCounter ++;
            }
        }
    }
}