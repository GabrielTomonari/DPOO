
/**
 * Montador
 */
import java.util.Scanner;

public class Montador {
    CSVHandling csv;
    Componente heroi;

    Montador(CSVHandling csv) {
        this.csv = csv;
    }

    public void montarCaverna(Caverna cave) {
        int jogadores = 0, buracos = 0, wumpus = 0, ouros = 0;
        String[][] data = csv.requestCommands();
        for (int i = 0; i < data.length; i++) {
            Componente componente = null;
            Componente auxiliar = null;

            Posicao pos = new Posicao(data[i][0]);
            switch (data[i][1]) {
                case "P":
                    jogadores++;
                    componente = new Heroi(pos, cave);
                    inserirNome(componente);
                    this.heroi = componente;
                    auxiliar = new Vazia(pos, cave);
                    auxiliar.posicionar();
                    break;
                case "B":
                    buracos++;
                    componente = new Buraco(pos, cave);
                    break;
                case "O":
                    ouros++;
                    componente = new Ouro(pos, cave);
                    auxiliar = new Vazia(pos, cave);
                    auxiliar.posicionar();
                    break;
                case "W":
                    wumpus++;
                    componente = new Wumpus(pos, cave);
                    auxiliar = new Vazia(pos, cave);
                    auxiliar.posicionar();
                    break;
                default:
                    componente = new Vazia(pos, cave);
                    break;
            }
            if (!componente.posicionar()) {
                System.out.println("Não pode haver Wumpus, Buraco ou Ouro no mesmo local");
                System.exit(0);
            }
            ;
        }
        if (jogadores != 1) {
            System.out.println("O jogo deve ter exatamente 1 jogador");
            System.exit(0);
        }
        if (buracos < 2 || buracos > 3) {
            System.out.println("A caverna deve ter 2 ou 3 buracos");
            System.exit(0);
        }
        if (ouros != 1) {
            System.out.println("A caverna deve ter exatamente 1 ouro");
            System.exit(0);
        }
        if (wumpus != 1) {
            System.out.println("A caverna deve ter exatamente 1 Wumpus");
            System.exit(0);
        }
    }

    public void inserirNome(Componente heroi) {
        Heroi heroiCast = (Heroi) heroi;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem:");
        String command = keyboard.nextLine();
        heroiCast.nome = command;
        System.out.println("--------------------------------");
        System.out.println("");
    }

    public Componente pegarHeroi() {
        return this.heroi;
    }
}