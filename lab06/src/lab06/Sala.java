import java.lang.reflect.Array;

public class Sala {
    private Componente[] componentes;
    private boolean foiVisitada;
    
    Sala(){
        
    }

    public void colocarComponente(Componente componente){
        Componente[] temp;
        temp = new Componente[this.componentes.length + 1];
        for (int i = 0; i < componentes.length; i++) {
            temp[i] = this.componentes[i];
        }
        temp[componentes.length] = componente;

        this.componentes = temp;
    }

    public boolean validarColocacao(Componente componente){
        return true;
    }

    public Componente listarImpressao(){
        for (int i = 0; i < componentes.length; i++) {
            
        }
    }

}
