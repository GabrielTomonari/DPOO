/**
 * Wumpus
 */
public class Wumpus extends ComponenteInvocador {
    Wumpus(Posicao pos, Caverna cave) {
        super(Componente.Tipos.WUMPUS, pos, cave);
    }

    @Override
    protected void iniciarInstancias(Posicao[] adjacentes) {
        for (Posicao posicao : adjacentes) {

            new Fedor(posicao, this.cave).posicionar();

        }
    }

}