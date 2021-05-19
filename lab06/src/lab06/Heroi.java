import java.util.*;

/**
 * Heroi
 */
public class Heroi extends Componente {

    static enum ACOES {
        VITORIA, MORTE, MOVIMENTO, FLECHA, WUMPUS
    }

    int pontos;
    String nome;
    boolean temFlecha, flechaEquipada, temOuro, taMorto, ganhou;

    Heroi(Posicao pos, Caverna cave) {
        super(Componente.Tipos.HEROI, pos, cave);
        this.pontos = 0;
        this.nome = "";
        this.temFlecha = true;
        this.flechaEquipada = false;
        this.temOuro = false;
        this.taMorto = false;
        this.ganhou = false;
    }

    @Override
    boolean validarMovimento(Posicao pos) {
        return (!this.taMorto) && (!this.ganhou) && this.cave.validarColocacao(pos, this);
    }

    @Override
    void sairDaSala() {
        this.cave.removerComponente(this, this.pos);
    }

    @Override
    void moverPara(Posicao pos) {
        this.pos = pos;
        posicionar();
    }

    private boolean ehSalaIncial() {
        if (this.pos.linha == 0 && this.pos.coluna == 0) {
            return true;
        }
        return false;
    }

    @Override
    boolean posicionar() {
        super.posicionar();
        this.cave.marcarSalaVisitada(this.pos);
        if (ehSalaIncial() && this.temOuro) {
            this.alterarPontuacao(ACOES.VITORIA);
            this.ganhou = true;
        }
        this.verificarBuraco();
        this.verificarWumpus();
        return true;
    }

    void equiparFlecha() {
        if (this.temFlecha) {
            this.temFlecha = false;
            this.flechaEquipada = true;
            alterarPontuacao(ACOES.FLECHA);
            System.out.println("Flecha equipada!");
        } else if (this.temFlecha == false && this.flechaEquipada) {
            this.temFlecha = true;
            this.flechaEquipada = false;
            System.out.println("Flecha guardada!");
        } else {
            System.out.println("Você não possui flechas!");
        }
    }

    void perderFlecha() {
        if (this.flechaEquipada) {
            this.flechaEquipada = false;
        }
    }

    public void alterarPontuacao(ACOES movimento) {
        switch (movimento) {
            case VITORIA:
                this.pontos += 1000;
                break;
            case MORTE:
                this.pontos -= 1000;
                break;
            case MOVIMENTO:
                this.pontos -= 15;
                break;
            case FLECHA:
                this.pontos -= 100;
                break;
            case WUMPUS:
                this.pontos += 500;
                break;
            default:
                break;
        }
    }

    public void pegarOuro() {
        if (this.cave.existeComponenteDoTipo(Componente.Tipos.OURO, this.pos)) {
            this.cave.removerOuro(this.pos);
            this.temOuro = true;
        }
    }

    public void verificarBuraco() {
        if (this.cave.existeComponenteDoTipo(Componente.Tipos.BURACO, this.pos)) {
            this.taMorto = true;
            this.alterarPontuacao(ACOES.MORTE);
        }
    }

    public void verificarWumpus() {
        if (this.cave.existeComponenteDoTipo(Componente.Tipos.WUMPUS, this.pos)) {
            combaterWumpus();
        }
    }

    public void combaterWumpus() {

        Random ran = new Random();

        if (this.flechaEquipada) {
            int chance = ran.nextInt(2);
            if (chance == 0) {
                this.alterarPontuacao(ACOES.MORTE);
                this.taMorto = true;
            } else if (chance == 1) {
                this.alterarPontuacao(ACOES.WUMPUS);
                this.cave.removerWumpus(this.pos);
            }
        } else {
            this.alterarPontuacao(ACOES.MORTE);
            this.taMorto = true;
        }
    }
}