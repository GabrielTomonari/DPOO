public class Piece {
    public char pieceColor;
    MatrixPosition pos;

    public MatrixPosition executeMove(MatrixPosition target) {
        this.pos = target;
        return this.pos;
    }

    public boolean solicitaMovimento(MatrixPosition target) {
        return true;
    }

    public boolean solicitaMovimento(MatrixPosition target, Piece pieceToCapture) {
        return true;
    }
}
