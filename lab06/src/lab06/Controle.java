import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 * Controle
 */
public class Controle {
    enum Comandos{
        CIMA, DIREITA, ESQUERDA, BAIXO, SAIR
    }
    boolean ehJogo;
    Componente heroi;
    Comandos comando;
    Scanner keyboard = new Scanner(System.in);
    

    Controle(Componente heroi) {
        this.ehJogo = true;
        this.comando = null;
        this.heroi = heroi;
    }

    public void leComando() {
        String command = keyboard.nextLine();
        if (command == "d") {
            this.comando = Comandos.DIREITA;
        }
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