/**
 * Caverna
 */
public class Caverna {
    Sala salas[][];

    Caverna() {
        salas = new Sala[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                salas[i][j] = new Sala();
            }
        }
        salas[0][0].colocarComponente(new Vazia(new Posicao(0,0), this));
        salas[0][0].marcarVisitada();
    }

    void colocarComponente(Componente componente, Posicao posicao) {
        Sala salaAlvo = salas[posicao.linha][posicao.coluna];

        if (salaAlvo.validarColocacao(componente)) {
            salaAlvo.colocarComponente(componente);
        }
    }

    void removerComponente(Componente componente, Posicao posicao) {
        Sala salaAlvo = salas[posicao.linha][posicao.coluna];

        salaAlvo.removerComponente(componente);

    }

    public void imprimeEstado() {
        int line = 4;
        for (int i = 0; i < 4; i++) {
            System.out.print(line + " ");
            line--;
            for (int j = 0; j < 4; j++) {
                System.out.print(salas[i][j].listarImpressao() + " ");
            }
            System.out.println("");
        }
        System.out.println("  1 2 3 4");
    }

}