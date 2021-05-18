/**
 * Componente
 */

public abstract class Componente {
    static enum Tipos {
        BURACO, HEROI, OURO, WUMPUS, BRISA, FEDOR, VAZIA, VISITADO
    }

    Tipos tipo;
    Posicao pos;
    Caverna cave;

    Componente(Tipos tipo, Posicao pos, Caverna cave) {
        this.tipo = tipo;
        this.pos = pos;
        this.cave = cave;
    }

    void posicionar(){
        this.cave.colocarComponente(this, this.pos);
    }
}