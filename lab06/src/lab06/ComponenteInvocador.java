/**
 * ComponenteInvocador
 */
public abstract class ComponenteInvocador extends Componente{
    ComponenteInvocador(Componente.Tipos tipo, Posicao pos, Caverna cave){
        super(tipo, pos, cave);
        inserirAdjacentes();
    }

    public void inserirAdjacentes(){
        Posicao[] adjacentes = new Posicao[]{
            new Posicao(this.pos.linha-1, pos.coluna),
            new Posicao(this.pos.linha+1, pos.coluna),
            new Posicao(this.pos.linha, pos.coluna-1),
            new Posicao(this.pos.linha, pos.coluna+1),
        };
        this.iniciarInstancias(adjacentes);
    }

    protected void iniciarInstancias(Posicao[] adjacentes){
        return;
    }
}