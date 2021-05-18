/**
 * Montador
 */
public class Montador {
    CSVHandling csv;
    Componente heroi;

    Montador(CSVHandling csv) {
        this.csv = csv;
    }

    public void montarCaverna(Caverna cave) {
        String[][] data = csv.requestCommands();
        for (int i = 0; i < data.length; i++) {
            Componente componente = null;
            
            Posicao pos = new Posicao(data[i][0]);
            switch (data[i][1]) {
                case "P":
                    componente = new Heroi(pos, cave);
                    this.heroi = componente;
                    break;
                case "B":
                    componente = new Buraco(pos, cave);
                    break;
                case "O":
                    componente = new Ouro(pos, cave);
                    break;
                case "W":
                    componente = new Wumpus(pos, cave);
                    break;
                default:
                    componente = new Vazia(pos, cave);
                    break;
            }
            componente.posicionar();
        }
    }

    public Componente pegarHeroi() {
        return this.heroi;
    }
}