/**
 * Componente
 */

public abstract class Componente {
    static enum Tipos {
        BURACO, HEROI, OURO, WUMPUS, BRISA, FEDOR, VAZIA
    }

    Tipos tipo;
    Posicao pos;
    Caverna cave;

    static int pegarPrioridade(Componente componente) {
        switch (componente.tipo) {
            case BURACO:
            case OURO:
            case WUMPUS:
                return 4;
            case HEROI:
                return 3;
            case FEDOR:
                return 2;
            case BRISA:
                return 1;
            default:
                return 0;
        }
    }

    Componente(Tipos tipo, Posicao pos, Caverna cave) {
        this.tipo = tipo;
        this.pos = pos;
        this.cave = cave;
    }

    boolean posicionar() {
        if (this.cave.validarColocacao(this.pos, this)) {
            this.cave.colocarComponente(this, this.pos);
            return true;
        }
        return false;
    }

    boolean validarMovimento(Posicao pos) {
        return true;
    }

    void sairDaSala() {
        this.cave.removerComponente(this, this.pos);
    }

    void moverPara(Posicao pos) {
        this.pos = pos;
        this.cave.colocarComponente(this, this.pos);
    }
}