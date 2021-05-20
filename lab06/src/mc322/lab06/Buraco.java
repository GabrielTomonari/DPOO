/**
 * Buraco
 */
public class Buraco extends ComponenteInvocador{
    Buraco(Posicao pos, Caverna cave) {
        super(Componente.Tipos.BURACO, pos, cave);
    }

    @Override
    protected void iniciarInstancias(Posicao[] adjacentes) {
        for (Posicao posicao : adjacentes) {

            new Brisa(posicao, this.cave).posicionar();

        }
    }
}