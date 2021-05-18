import java.time.format.FormatStyle;

/**
 * Controle
 */
public class Controle {
    boolean ehJogo;
    Componente heroi;

    Controle(Componente heroi) {
        this.ehJogo = true;
        this.heroi = heroi;
    }

    public void leComando() {
        //le o comando e guarda num enum
    }


    private Posicao calculaPosicao(){
        return new Posicao(1,1);
    }

    public void executaComando() {
        Posicao posAlvo = calculaPosicao();
        if(this.heroi.validarMovimento(posAlvo)){
            this.heroi.sairDaSala();
            this.heroi.moverPara(posAlvo);    
        }
    }

}