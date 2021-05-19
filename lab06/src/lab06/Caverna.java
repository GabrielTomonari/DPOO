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
    }

    private Sala salaEm(Posicao posicao){
        return salas[posicao.linha][posicao.coluna];
    }

    boolean validarColocacao(Posicao posicao, Sala salaAlvo, Componente componente){
        if(posicao.linha < 0 || posicao.linha >= salas.length){
            return false;
        }
        if(posicao.coluna < 0 || posicao.coluna >= salas[0].length){
            return false;
        }
        return salaAlvo.validarColocacao(componente);
    }

    void colocarComponente(Componente componente, Posicao posicao) {
        Sala salaAlvo = salaEm(posicao);

        if (this.validarColocacao(posicao, salaAlvo, componente)) {
            salaAlvo.colocarComponente(componente);
        }
    }

    void marcarSalaVisitada(Posicao posicao) {
        Sala salaAlvo = salaEm(posicao);

        salaAlvo.marcarVisitada();
    }

    void removerComponente(Componente componente, Posicao posicao) {
        Sala salaAlvo = salaEm(posicao);

        salaAlvo.removerComponente(componente);

    }

    public void imprimeSalas() {
        int line = 4;
        for (int i = 0; i < 4; i++) {
            System.out.print(line + " ");
            line--;
            for (int j = 0; j < 4; j++) {
                System.out.print(salas[i][j].listarImpressao() + " ");
            }
            System.out.println("");
        }
        System.out.println("  1 2 3 4\n");
    }

    public boolean existeComponenteDoTipo(Componente.Tipos tipo, Posicao posicao){
        Sala salaAlvo = salaEm(posicao);

        if(salaAlvo.buscarComponente(tipo) != null){
            return true;
        }else{
            return false;
        }
    }

    public void removerOuro(Posicao posicao){
        Sala salaAlvo = salaEm(posicao);
        Ouro ouro = (Ouro) salaAlvo.buscarComponente(Componente.Tipos.OURO);

        salaAlvo.removerComponente(ouro);
    }

    public void removerWumpus(Posicao posicao){
        Sala salaAlvo = salaEm(posicao);
        Wumpus wumpus = (Wumpus) salaAlvo.buscarComponente(Componente.Tipos.WUMPUS);

        salaAlvo.removerComponente(wumpus);
    }

}