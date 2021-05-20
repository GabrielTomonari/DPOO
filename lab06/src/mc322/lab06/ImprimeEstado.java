public class ImprimeEstado {
    Heroi heroi;
    Caverna cave;

    ImprimeEstado(Caverna cave, Controle controle) {
        this.heroi = controle.heroi;
        this.cave = cave;
    }

    void imprimirEstado() {

        System.out.println("");
        this.cave.imprimeSalas();
        System.out.println("Player: " + heroi.nome);
        System.out.println("Score: " + heroi.pontos);
        if(this.heroi.taMorto){
            System.out.println("Você perdeu =( ...");
        }
        if(this.heroi.ganhou){
            System.out.println("Você ganhou =D !!!");
        }
    }

    void imprimirFimDeJogo(){
        System.out.println("Volte sempre !");
    }
}
