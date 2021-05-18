public class Posicao {
    int linha;
    int coluna;

    Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    Posicao(String pos) {
        int linha = Character.getNumericValue(pos.charAt(0));
        int coluna = Character.getNumericValue(pos.charAt(2));
        new Posicao(linha, coluna);
    }
}
