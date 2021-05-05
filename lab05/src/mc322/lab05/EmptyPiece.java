public class EmptyPiece extends Piece{
    EmptyPiece(MatrixPosition pos){
        this.pieceColor = '_';
        this.pos = pos;
    }

    @Override
    public boolean solicitaMovimento(MatrixPosition target) {
        return false;
    }

    @Override
    public boolean solicitaMovimento(MatrixPosition target, Piece pieceToCapture) {
        return false;
    }
}
