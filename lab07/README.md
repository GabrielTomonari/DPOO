# Apresentação do Projeto

# Projeto `POOtencial Evolutivo`

# Descrição Resumida do Projeto/Jogo

> Um jogo de plataforma cujo objetivo é batalhar com inimigos para adquirir genes que conferem ao jogador poderes especiais.
> O jogador precisa, ao longo das fases, coletar comida para não morrer de fome, pois sua energia decai a cada passo dado.
> O jogo é infinito, com cada fase gerada aleatóriamente. É possível disputar para ver quem vence mais fases.

# Equipe

- `Antonio D. Lucas Junior` - `165677`
- `Gabriel Eiji M. de M. Tomonari` - `234774`

# Vídeos do Projeto

## Vídeo da Prévia
> [Link para o vídeo](https://youtu.be/emUyXbDuNmo)

## Vídeo do Jogo

# Slides do Projeto

## Slides da Prévia
[Link para slides](https://docs.google.com/presentation/d/1r2Jii_VHBkU03k71rF_9ruOg5X7HX8bxM-2oBistcn0/edit?usp=sharing)

## Slides da Apresentação Final

## Relatório de Evolução
> O projeto começou com um jogo totalmente diferente. Com uma implementação estilo jogo de damas e com uma arquitetura mais simples. Após feedbacks do professor, resolvemos mudar completamente o projeto e fazer um jogo no estilo RPG.
> Na nossa primeira fase de implementação, nos concentramos na framework JavaFX e na geração automática do tabuleiro. Construímos o mecanismo de colocação dos obstaculos automaticamente, assim como o jogador.
> Na segunda fase de implementação focamos no complemento da inferface, adicionando as informações do personagem, como vida, energia etc. Além disso, construímos a lógica de movimentação do personagem, assim como a lógica de obtenção de comida, perda de energia e ganho de vida.
> Já na última fase de implementação, focamos na lógica de combate e aquisição de genes.

# Destaques de Código

> O PrintableBoardState foi uma maneira elegante que encontramos de desacoplar o tabuleiro da interface gráfica. A partir desta classe, é possível obter uma versão imprimível do tabuleiro, possibilitando trabalhar não com os dados diretos do tabuleiro, mas sim com métodos que obtém os dados de cada célula de maneira dinâmica, permitindo a componentização e fácil modificação ou incremento do jogo.

```java
public class PrintableBoardState {
    private int columnMax = 16;
    private int lineMax = 16;
    private String[][] images;
    private int lineCounter;
    private int columnCounter;
    private boolean hasFinished;

    public PrintableBoardState() {
        this.images = new String[lineMax][columnMax];
    }

    public void appendImage(int i, int j, String path) {
        this.images[i][j] = path;
    }

    public void resetCounter() {
        this.lineCounter = 0;
        this.columnCounter = 0;
        hasFinished = false;
    }

    public int currentLine() {
        return lineCounter;
    }

    public int currentColumn() {
        return columnCounter;
    }

    public String getCurrentImage() {
        return images[lineCounter][columnCounter];
    }

    public void changeToNextImage() {
        columnCounter++;
        if (columnCounter == columnMax) {
            columnCounter = 0;
            lineCounter++;
            if (lineCounter == lineMax) {
                hasFinished = true;
            }
        }
    }

    public boolean shouldPrintNext() {
        return !hasFinished;
    }
}
```

# Destaques de Pattern
> O pattern de Observer permite um funcionamento orientado por eventos. O observable é um emissor de eventos, como por exemplo quando o jogador coleta um item no mapa. O pattern reduz o acoplamento entre duas classes, permitindo fazer isso de forma dinâmica que facilita futuras implementações.

## Diagrama do Pattern

## Código do Pattern
```java
public abstract class BaseObervable<ListenerType, InfoType> {
    protected List<ListenerType> observers = new ArrayList<>();

    public void addObserver(ListenerType observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ListenerType observer) {
        this.observers.remove(observer);
    }

    abstract protected void notifyListeners(InfoType info);
}
```

# Conclusões e Trabalhos Futuros
> Ao longo do projeto tivemos várias ideias que foram despriorizadas por falta de tempo. A primeira e mais simples foi da implementação de gifs animados no lugar do personagem e inimigos. Imaginamos que essa função não seja muito difícil de implementar, mas acabamos não dando prioridade.
> Da mesma forma, acabamos simplificando bastante a lógica de combate por conta do tempo. A ideia inicial era de ter uma interface própria e separada para combate, com uma possível escolha de tipos de ataques, animações etc. Com a arquitetura implementada, não seria muito difícil fazer essas adições, mas acrescentaria bastante tempo de trabalho ao projeto e, por isso, acabamos não o fazendo.
> Por fim, percebemos que a arquitetura proposta através de componentes e suas interfaces permitem a adição de novas funções de maneira muito rápida e sem interferir no funcionamento básico do jogo.

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

![Diagrama](assets/previa/img/diagrama_fluxo.png)

> Acima o diagrama geral do projeto, considerando componentes principais, interfaces e o fluxo de dados entre eles.

## Diagrama Geral de Componentes

Este é o diagrama compondo componentes para análise:

![Diagrama](assets/previa/img/diagrama.jpg)

Para cada componente será apresentado uma descrição detalhada a seguir:

## Componente `BoardManager`

> Componente responsável por gerenciar o estado do Tabuleiro, o estado é uma matriz onde cada célula guarda as informações a serem renderizadas na tela, além disso cada célula guarda as informações de interação do jogo. O componente expõem métodos para interagir com as células, bem como exportar seus estado numa versão simplicada para renderização.

![Componente](assets/previa/img/componente_roomstatemanager.jpg)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `lab07.src.src.BoardManager`
Autores | `Antonio D Lucas Junior` <br> `Gabriel Eiji M. de M. Tomonari`
Interfaces | `iBoardManager` <br> `iBoardManConsumer`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](assets/previa/img/boardinterface.png)

Interface agregadora do componente em Java:

```java
public interface iBoardStateManager extends iBoardGenerator, iBoardView {

}
```

## Detalhamento das Interfaces

### Interface `iBoardManager`

`?`.

```java
public interface iBoardManager extends iBoardView, iBoardStateController, iHeroManConsumer, iUIManConsumer {

}
```

### Interface `iBoardManConsumer`

`?`.

```java
public interface iBoardManConsumer {
    public void connectBoard(iBoardManager board);
}
```

| Método                      | Objetivo                                                       |
| --------------------------- | -------------------------------------------------------------- |
| `connectBoard` | `?` |

## Componente `UIManager`

> Componente responsável por gerenciar o sistema de renderização das informações na Interface de Usuário. Suas responsabilidades envolvem, controle de clock, controle de cenas e renderização de imagens.

![Componente](assets/previa/img/componente_uimanager.jpg)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `lab07.src.src.UIManager`
Autores | `Antonio D Lucas Junior` <br> `Gabriel Eiji M. de M. Tomonari`
Interfaces | `iUIManager` <br> `iUIManConsumer`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](assets/previa/img/uiinterface.png)

Interface agregadora do componente em Java:

```java
public interface iUIManager extends iHeroManConsumer, iBoardManConsumer {

    public void updateState();

    public void setStage(Stage stage);

    public void render();
}
```

## Detalhamento das Interfaces

### Interface `iUIManager`

`Interface principal que expõem os métodos para os demais componentes`.

```java
public interface iUIManager {
    public void updateState();

    public void setStage(Stage stage);

    public void render();
}
```

| Método        | Objetivo                                                                                                                                                                                        |
| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `updateState` | `Atualiza o estado da tela, renderizando uma nova cena para o usuário`                                                                                                                          |
| `setStage`    | `seta o stage inicial do JAVAFX, necessário para a utilização do framework, o stage representa a janela exibida para o usuário. Além disso realiza configurações da tela como tamanho e título` |
| `render`      | `renderiza o estado atual na interface para o usuario, chamada a cada pulso de clock`                                                                                                           |

### Interface `iUIManConsumer`

`?`.

```java
public interface iUIManConsumer {
    public void connectUI(iUIManager uiManager);
}
```

| Método         | Objetivo                                                                                |
| -------------- | --------------------------------------------------------------------------------------- |
| `connectUI` | `?` |

## Componente `HeroManager`

> Componente responsável por gerenciar o estado do Herói, bem como fornecer metódos e funções para alterar tais estados.

![Componente](assets/previa/img/herointerface.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `lab07.src.src.HeroManager`
Autores | `Antonio D Lucas Junior` <br> `Gabriel Eiji M. de M. Tomonari`
Interfaces | `iHeroManager` <br> `iHeroManConsumer`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](assets/previa/img/herointerface.png)

Interface agregadora do componente em Java:

```java
public interface iHeroManager {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
```

## Detalhamento das Interfaces

### Interface `iHeroManager`

`Interface principal que expõem os métodos para os demais componentes`.

```java
public interface iHeroManager {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
```

| Método                   | Objetivo                                                                               |
| ------------------------ | -------------------------------------------------------------------------------------- |
| `isAlive`                | `informa se a vida do heroi é maior que zero, usada para continuar o loop do jogo`     |
| `expPrintableHeroStatus` | `retorna uma versão do estado do heroi, facilitada para a impressão`                   |
| `placeHero`              | `altera a posição do herói para a posição inicial da sala, por hora setada como (0,0)` |

### Interface `iHeroManConsumer`

`Interface principal que expõem os métodos para os demais componentes`.

```java
public interface iHeroManager {

    public boolean isAlive();

    public PrintableHeroStatus expPrintableHeroStatus();

    public void placeHero();
}
```

| Método                   | Objetivo                                                                               |
| ------------------------ | -------------------------------------------------------------------------------------- |
| `isAlive`                | `informa se a vida do heroi é maior que zero, usada para continuar o loop do jogo`     |
| `expPrintableHeroStatus` | `retorna uma versão do estado do heroi, facilitada para a impressão`                   |
| `placeHero`              | `altera a posição do herói para a posição inicial da sala, por hora setada como (0,0)` |

# Plano de Exceções

## (Ainda não implementado)
