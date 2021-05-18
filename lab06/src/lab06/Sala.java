import java.lang.reflect.Array;

public class Sala {
    private Componente[] componentes;
    private boolean foiVisitada;

    Sala() {

    }

    public void colocarComponente(Componente componente) {
        Componente[] temp;
        temp = new Componente[this.componentes.length + 1];
        for (int i = 0; i < componentes.length; i++) {
            temp[i] = this.componentes[i];
        }
        temp[componentes.length] = componente;

        this.componentes = temp;
    }

    public boolean validarColocacao(Componente componente) {
        return true;
    }

    public Componente listarImpressao() {
        Componente temp = null;
        for (int i = 0; i < componentes.length; i++) {
            switch (componentes[i].tipo) {
                case BRISA:
                    temp = componentes[i];
                    break;
                case FEDOR:
                    temp = componentes[i];
                    break;
                case HEROI:
                    temp = componentes[i];
                    break;
                case WUMPUS:
                    temp = componentes[i];
                    return temp;
                case OURO:
                    temp = componentes[i];
                    return temp;
                case BURACO:
                    temp = componentes[i];
                    return temp;
                default:
                    break;
            }
        }
        return temp;
    }

}
