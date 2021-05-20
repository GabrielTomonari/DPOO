public class Posicao {
    int linha;
    int coluna;

    Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    Posicao(String pos) {
        this(Character.getNumericValue(pos.charAt(0))-1, Character.getNumericValue(pos.charAt(2))-1);
    }
}
