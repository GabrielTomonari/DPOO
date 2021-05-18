/**
 * Caverna
 */
public class Caverna {
    Sala salas[][];

    Caverna() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                salas[i][j] = new Sala();
            }
        }
    }

    void colocarComponente(Componente componente, Posicao posicao) {
        Sala salaAlvo = salas[posicao.linha][posicao.coluna];

        if (salaAlvo.validarColocacao(componente)) {
            salaAlvo.colocarComponente(componente);
        }
    }

    void removerComponente(Componente componente, Posicao posicao) {

    }

    public void imprimeEstado() {
        int line = 4;
        for (int i = 0; i < 4; i++) {
            System.out.print(line + " ");
            line--;
            for (int j = 0; j < 4; j++) {
                System.out.println("oi");
            }
        }
    }

}