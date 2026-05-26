# Chess System

Sistema de xadrez desenvolvido em **Java**, executado diretamente no terminal com interface colorida e interativa. O projeto implementa todas as regras do xadrez, incluindo movimentos especiais, e foi desenvolvido como estudo de **Programação Orientada a Objetos**.

---

## Demonstração

```
8 R N B Q K B N R
7 P P P P P P P P
6 - - - - - - - -
5 - - - - - - - -
4 - - - - - - - -
3 - - - - - - - -
2 P P P P P P P P
1 R N B Q K B N R
  a b c d e f g h

Source: _
```

---

## Funcionalidades

-  Jogo de xadrez completo para **dois jogadores** no terminal
-  Tabuleiro com **cores ANSI** para melhor visualização
-  Validação de **movimentos legais** com destaque no tabuleiro
-  Detecção de **xeque** e **xeque-mate**
-  Suporte a movimentos especiais:
  - **Roque** (pequeno e grande)
  - **En Passant**
  - **Promoção de peão**
-  Rastreamento de **peças capturadas**
-  Contador de **turnos**

---

## Tecnologias

- **Java** (JDK 11+)
- Orientação a Objetos (Herança, Polimorfismo, Encapsulamento)
- Tratamento de exceções customizadas
- Estruturas de dados (matrizes, listas)

---

## Estrutura do Projeto

```
chess_system/
└── src/
    ├── application/
    │   ├── Program.java          # Ponto de entrada da aplicação
    │   └── UI.java               # Interface do usuário (renderização do tabuleiro)
    ├── boardgame/
    │   ├── Board.java            # Lógica do tabuleiro genérico
    │   ├── BoardException.java   # Exceção de tabuleiro
    │   ├── Piece.java            # Classe abstrata de peça
    │   └── Position.java         # Posição no tabuleiro (linha/coluna)
    └── chess/
        ├── ChessException.java   # Exceção específica do xadrez
        ├── ChessMatch.java       # Controle da partida
        ├── ChessPiece.java       # Abstração de peça de xadrez
        ├── ChessPosition.java    # Posição no formato xadrez (ex: a1, e4)
        ├── Color.java            # Enum de cores (BLACK/WHITE)
        └── pieces/
            ├── Bishop.java       # Bispo
            ├── King.java         # Rei
            ├── Knight.java       # Cavalo
            ├── Pawn.java         # Peão
            ├── Queen.java        # Rainha
            └── Rook.java         # Torre
```

---

## Como Executar

### Pré-requisitos

- [JDK 11+]
- Terminal com suporte a cores ANSI (Linux, macOS ou Windows Terminal)

### Clonar o repositório

```bash
git clone https://github.com/PedroLins04/chess_system.git
cd chess_system
```

### Executar
Com o terminal aberto em "/chess_system/src/Application" execute:

```bash
java Program.java
```

>  **Dica**: No Windows, use o **Git Bash** para a exibição correta das cores ANSI.

---

## Como Jogar

1. Ao iniciar, o tabuleiro será exibido no terminal
2. O **jogador Roxo** sempre começa
3. **Digite a posição de origem** da peça que deseja mover (ex: `e2`)
4. As **casas possíveis** serão destacadas no tabuleiro
5. **Digite a posição de destino** (ex: `e4`)
6. O turno passa para o próximo jogador
7. O jogo termina com **xeque-mate**

### Notação de posição

As posições seguem a **notação algébrica do xadrez**:
- Letras de `a` a `h` representam as **colunas**
- Números de `1` a `8` representam as **linhas**
- Exemplo: `e2`, `d7`, `a1`

---

## Conceitos de POO Aplicados

| Conceito | Aplicação |
|---|---|
| **Herança** | `ChessPiece` estende `Piece`; cada peça estende `ChessPiece` |
| **Polimorfismo** | Método `possibleMoves()` implementado por cada tipo de peça |
| **Encapsulamento** | Atributos privados com acesso controlado |
| **Exceções** | `BoardException` e `ChessException` para erros específicos |
| **Classes Abstratas** | `Piece` e `ChessPiece` são abstratas |
| **Enum** | `Color` para representar as cores das peças |

---

## Autor

**Pedro Lins**

[![GitHub](https://img.shields.io/badge/GitHub-PedroLins04-181717?style=flat&logo=github)](https://github.com/PedroLins04)
