import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 * Controle
 */
public class Controle {
    enum Comandos {
        CIMA, DIREITA, ESQUERDA, BAIXO, SAIR, INVALIDO, PEGAR, FLECHA
    }

    boolean ehJogo;
    Heroi heroi;
    Comandos comando;
    Scanner keyboard = new Scanner(System.in);

    Controle(Heroi heroi) {
        this.ehJogo = true;
        this.comando = Comandos.INVALIDO;
        this.heroi = heroi;
    }

    public void leComando() {
        System.out.print("Digite o comando: ");
        String command = keyboard.nextLine();

        if (command != null && command.length() == 1) {
            switch (command.charAt(0)) {
                case 'd':
                    this.comando = Comandos.DIREITA;
                    break;
                case 'a':
                    this.comando = Comandos.ESQUERDA;
                    break;
                case 's':
                    this.comando = Comandos.BAIXO;
                    break;
                case 'w':
                    this.comando = Comandos.CIMA;
                    break;
                case 'c':
                    this.comando = Comandos.PEGAR;
                    break;
                case 'k':
                    this.comando = Comandos.FLECHA;
                    break;
                case 'q':
                    this.comando = Comandos.SAIR;
                    break;
                default:
                    this.comando = Comandos.INVALIDO;
                    break;
            }
        } else {
            System.out.println("Comando deve ser de uma letra!");
        }
    }

    public void executaComando() {
        switch (this.comando) {
            case CIMA:
            case BAIXO:
            case ESQUERDA:
            case DIREITA:
                executaMovimento();
                break;
            case PEGAR:
                pegarOuro();
                break;
            case FLECHA:
                this.heroi.equiparFlecha();
                break;
            case SAIR:
                this.ehJogo = false;
                break;
            default:
                break;
        }
    }

    private Posicao calculaPosicao() {
        Posicao novaPos, posAtual = this.heroi.pos;
        switch (this.comando) {
            case DIREITA:
                novaPos = new Posicao(posAtual.linha, posAtual.coluna + 1);
                break;
            case ESQUERDA:
                novaPos = new Posicao(posAtual.linha, posAtual.coluna - 1);
                break;
            case CIMA:
                novaPos = new Posicao(posAtual.linha - 1, posAtual.coluna);
                break;
            case BAIXO:
                novaPos = new Posicao(posAtual.linha + 1, posAtual.coluna);
                break;
            default:
                novaPos = posAtual;
                break;
        }

        return novaPos;
    }

    private void executaMovimento() {
        Posicao posAlvo = calculaPosicao();
        if (this.heroi.validarMovimento(posAlvo)) {
            this.heroi.sairDaSala();
            this.heroi.moverPara(posAlvo);
            this.heroi.alterarPontuacao(Heroi.ACOES.MOVIMENTO);
            this.heroi.perderFlecha();
        }
    }

    private void pegarOuro() {
        this.heroi.pegarOuro();
    }

}