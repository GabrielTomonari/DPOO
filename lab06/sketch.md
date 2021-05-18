# Lab 06 - Wumpus

## Arquitetura

Descrição das responsabilidades:

### Montador
- Deve instanciar os objetos componentes
- Conecta ao csv handler

### Caverna
- Cria as salas 
- Conecta o objeto componente
- Mantem estado das salas
- Atualiza o estado das salas

### Componente
- Mantem a posição atual

### Componente Generator
- Extende o Componente
- Gerar novos componentes

### Wumpus
- Extende o Componente Generator

### Buraco
- Extende o Componente Generator

### Sala
- Valida a colocação do objeto
- Atualiza o estado interno

### Controle
- Cuida do input de comandos e repassa para o heroi

### Heroi
- Extende o Componente
- Comunica com a caverna para mover
- Interagir com o objeto

### AppMundoWumpus
- Função principal

### Ouro
- Extende Componente

### Fedor
- Extende Componente

### Brisa
- Extende Componente