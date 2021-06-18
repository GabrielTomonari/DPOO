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

# Slides do Projeto

## Slides da Prévia

[Link para slides](https://docs.google.com/presentation/d/1r2Jii_VHBkU03k71rF_9ruOg5X7HX8bxM-2oBistcn0/edit?usp=sharing)

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

![Diagrama]()

> Acima o diagrama geral do projeto, considerando componentes principais, interfaces e o fluxo de dados entre eles.

## Diagrama Geral de Componentes

Este é o diagrama compondo componentes para análise:

![Diagrama](assets\previa\img\diagrama.jpg)

Para cada componente será apresentado uma descrição detalhada a seguir:

## Componente `HeroManager`

> Componente responsável por gerenciar o estado do Herói, bem como fornecer metódos e funções para alterar tais estados.

![Componente]()

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `lab07.src.src.HeroManager`
Autores | `Antonio D Lucas Junior` <br> `Gabriel Eiji M. de M. Tomonari`
Interfaces | ``

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

```java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
```

## Detalhamento das Interfaces

### Interface `<nome da interface>`

`<Resumo do papel da interface.>`

```
<Interface em Java.>
```

| Método                   | Objetivo                                          |
| ------------------------ | ------------------------------------------------- |
| `<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>` |

## Exemplo:

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

```java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
```

| Método              | Objetivo                                                                                                                                                                               |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.                                                                                                                 |
| `requestInstances`  | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`. |

### Interface `IDataSetProperties`

Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

```java
public interface IDataSetProperties {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
```

| Método          | Objetivo                                                                         |
| --------------- | -------------------------------------------------------------------------------- |
| `getDataSource` | Retorna o caminho da fonte de dados.                                             |
| `setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`. |

# Plano de Exceções

## Diagrama da hierarquia de exceções

`<Elabore um diagrama com a hierarquia de exceções como detalhado abaixo>`

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

`<Monte uma tabela descritiva seguindo o exemplo>:`

| Classe            | Descrição                                          |
| ----------------- | -------------------------------------------------- |
| DivisaoInvalida   | Engloba todas as exceções de divisões não aceitas. |
| DivisaoInutil     | Indica que a divisão por 1 é inútil.               |
| DivisaoNaoInteira | Indica uma divisão não inteira.                    |
