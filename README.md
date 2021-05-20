# Apresentação

Arquivo de Apresentação da Dupla.

Nome da Dupla: Dupla POOtente

## Alunos

- Antonio D Lucas Jr - RA 165677
- Gabriel Eiji Mariano de Menezes Tomonari - RA 234774

## Curso

- Engenharia da Computação

## Destaques da Arquitetura

```java
// Destaque do nosso código
public abstract class ComponenteInvocador extends Componente {

    ComponenteInvocador(Componente.Tipos tipo, Posicao pos, Caverna cave) {
        super(tipo, pos, cave);
        inserirAdjacentes();
    }

    public Posicao[] pegarPosAdjacentes() {
        ...
    }

    public void inserirAdjacentes() {
        ...
    }

    protected void iniciarInstancias(Posicao[] adjacentes) {
        ...
    }
}

```

Nessa aplicação observou-se uma notoria semelhança entre os Componentes Wumpus e Buraco, uma vez que ambos dão origem a novos componentes, respectivamente Brisa e Fedor. Com isso em mente e fazendo uso de boas práticas de arquitetura, optamos por centralizar a lógica comum entre eles em uma classe abstrata denominada de ComponenteInvocador, isto evitou a repetição de código entre as classes e facilitou a adição e remoção dos componentes Brisa e Fedor, já que isso era gerido de forma autonoma pelas classes Wumpus e Buraco. Além disso, caso fosse adicionado algum outro componente que "invocasse" subcomponentes, a logica poderia ser reutilizada.
