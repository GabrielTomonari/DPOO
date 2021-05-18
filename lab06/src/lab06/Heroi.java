/**
 * Heroi
 */
public class Heroi extends Componente {
    Heroi(Posicao pos, Caverna cave) {
        super(Componente.Tipos.HEROI, pos, cave);
    }

    boolean validarMovimento(Posicao pos){
        return true;
    }

    void sairDaSala(){
        this.cave.removerComponente(this, this.pos);
    }

    void moverPara(Posicao pos){
        this.pos = pos;
        this.cave.colocarComponente(this, this.pos);
    }
}