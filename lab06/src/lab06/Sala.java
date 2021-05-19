import java.lang.reflect.Array;

import Componente.Tipos;

public class Sala {
    private Componente[] componentes;
    private int qtdComponentes;
    private boolean foiVisitada;

    Sala() {
        this.componentes = new Componente[4];
        this.qtdComponentes = 0;
    }

    private void organizaComponentes() {
        for (int i = 0; i < this.qtdComponentes; i++) {
            for (int j = 0; j < (this.qtdComponentes - 1); j++) {
                if (Componente.pegarPrioridade(this.componentes[j]) > Componente
                        .pegarPrioridade(this.componentes[j + 1])) {
                    Componente aux = this.componentes[j];
                    this.componentes[j] = this.componentes[j + 1];
                    this.componentes[j + 1] = aux;
                }
            }
        }
    }

    public void colocarComponente(Componente componente) {

        this.componentes[this.qtdComponentes] = componente;
        this.qtdComponentes++;
        organizaComponentes();

        if (componente.tipo == Componente.Tipos.HEROI) {
            this.foiVisitada = true;
        }
    }

    public void removerComponente(Componente componente){
        Componente[] temp;
        for (int i = 0; i < this.qtdComponentes; i++) {
            if (componentes[i] == componente) {
                for (int j = i; j < this.qtdComponentes; j++) {
                    this.componentes[j] = this.componentes[j+1];
                }
            }
        }
        this.qtdComponentes--;
    }

    public boolean validarColocacao(Componente componente) {
        return true;
    }

    public char listarImpressao() {

        char resultado = '-';
        if (this.foiVisitada) {

            Componente temp = componentes[this.qtdComponentes - 1];
            switch (temp.tipo) {
                case BURACO:
                    resultado = 'B';
                    break;
                case HEROI:
                    resultado = 'P';
                    break;
                case OURO:
                    resultado = 'O';
                    break;
                case WUMPUS:
                    resultado = 'W';
                    break;
                case BRISA:
                    resultado = 'b';
                    break;
                case FEDOR:
                    resultado = 'F';
                    break;
                case VAZIA:
                    resultado = '#';
                    break;
                default:
                    break;
            }

        }

        return resultado;
    }

    public void marcarVisitada() {
        this.foiVisitada = true;
    }

}
