/**
 * AppMundoWumpus
 */
public class AppMundoWumpus {
    public static void main(String[] args) {
        String caminho_entrada = "/home/eiji/Development/MC322/DPOO/lab06/data/teste01.csv";
        
        // get the args value
        if (args.length != 0) {
            caminho_entrada = args[0];
        }

        // CSV Reader
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(caminho_entrada);

        // Caverna
        Caverna cave = new Caverna();

        // Montador
        Montador montador = new Montador(csv);
        montador.montarCaverna(cave);
        cave.imprimeEstado();

        // Controlador
        Controle controlador = new Controle(montador.pegarHeroi());
        while(controlador.ehJogo){
            controlador.leComando();
            controlador.executaComando();
            cave.imprimeEstado();
        }
    }
}