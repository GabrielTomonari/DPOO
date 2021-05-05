import java.lang.Math;

public class BoardState {

    private Piece[][] state;
    private String[] history;
    private int round;

    public BoardState(int numberOfCommands) {
        this.state = new Piece[8][8];
        this.history = new String[numberOfCommands];
        this.round = 0;

        // Iniciar a primeira posição
        System.out.println(" Tabuleiro inicial:");
        this.history[0] = "_p_p_p_p\np_p_p_p_\n_p_p_p_p\n________\n________\nb_b_b_b_\n_b_b_b_b\nb_b_b_b_\n";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.state[i][j] = new EmptyPiece(new MatrixPosition(i, j));
            }
        }
        for (int i = 1; i < 8; i = i + 2) {
            this.state[0][i] = new Man('p', new MatrixPosition(0, i));
            this.state[2][i] = new Man('p', new MatrixPosition(2, i));
            this.state[6][i] = new Man('b', new MatrixPosition(6, i));
        }
        for (int i = 0; i < 8; i = i + 2) {
            this.state[1][i] = new Man('p', new MatrixPosition(1, i));
            this.state[5][i] = new Man('b', new MatrixPosition(5, i));
            this.state[7][i] = new Man('b', new MatrixPosition(7, i));
        }
        this.imprimirTabuleiro();
        this.round++;
    }

    public Piece getPieceAt(MatrixPosition position) {
        return this.state[position.lin][position.col];
    }

    public void removePieceAt(MatrixPosition position) {
        this.state[position.lin][position.col] = new EmptyPiece(position);
    }

    public void placePieceAt(Piece piece, MatrixPosition position) {
        this.state[position.lin][position.col] = piece;
    }

    private String covertStateToString() {
        // Converte a matriz de estado para string
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                resultString.append(this.state[i][j].pieceColor);
            }
            resultString.append('\n');
        }

        String finalString = resultString.toString();
        return finalString;
    }

    public String[] convertStateToStringArray() {
        String[] result = new String[64];
        String[] singleResult = new String[1];
        singleResult[0] = "erro";
        int k = 0;

        if (this.history[this.round-1] == "Movimento Inválido!") {
            return singleResult;
        } else {

            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    switch (j) {
                        case 0:
                            result[k] = "a" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 1:
                            result[k] = "b" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 2:
                            result[k] = "c" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 3:
                            result[k] = "d" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 4:
                            result[k] = "e" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 5:
                            result[k] = "f" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 6:
                            result[k] = "g" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        case 7:
                            result[k] = "h" + (Math.abs(i - 8)) + this.state[i][j].pieceColor;
                            break;
                        default:
                            break;
                    }
                    k++;
                }
            }
        }
        return result;
    }

    public void saveStateOnHistory() {
        // Converte a matriz de estado para string e insere o resultado no histórico
        String result;
        result = this.covertStateToString();
        history[this.round] = result;
        this.round++;
    }

    public void imprimirTabuleiro() {
        int line = 8;
        // System.out.print("\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(line + " ");
            line--;
            for (int j = 0; j < 8; j++) {
                System.out.print(this.state[i][j].pieceColor + " ");
            }
            System.out.print("\n");
        }
        System.out.print("  a b c d e f g h\n");

    }

    public void saveError() {
        history[this.round] = "Movimento Inválido!";
        this.round++;
    }

    public void imprimirMensagemErro() {
        System.out.println("Movimento Inválido!");
    }

    public String[] returnStateAsArrayofString() {
        return this.history;
    }

}
