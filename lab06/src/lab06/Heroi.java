/**
 * Heroi
 */
public class Heroi extends Componente {
    Heroi(Posicao pos, Caverna cave) {
        super(Componente.Tipos.HEROI, pos, cave);
    }

    @Override
    boolean validarMovimento(Posicao pos){
        return true;
    }

    @Override
    void sairDaSala(){
        this.cave.removerComponente(this, this.pos);
    }

    @Override
    void moverPara(Posicao pos){
        this.pos = pos;
        this.cave.colocarComponente(this, this.pos);
    }
}