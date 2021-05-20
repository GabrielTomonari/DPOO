/**
 * AppMundoWumpus
 */
public class AppMundoWumpus {
    public static void main(String[] args) {
        String caminho_entrada=null;

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

        // Controlador
        Controle controlador = new Controle((Heroi) montador.pegarHeroi());

        // Imprime Estado
        ImprimeEstado imprime = new ImprimeEstado(cave, controlador);
        imprime.imprimirEstado();

        // Rotina de Jogo
        while (controlador.ehJogo) {
            controlador.leComando();
            controlador.executaComando();
            imprime.imprimirEstado();
        }
        imprime.imprimirFimDeJogo();
    }
}