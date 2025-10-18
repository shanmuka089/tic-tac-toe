Tic Tac Toe Game:

Functional Requirements:
========================
1. The game should support standard 3X3 Board.
2. User should be able to make valid moves on the board.
3. The game should detect win or draw based on the current state of the board.
4. The game should alternate turns between players.
5. The game should provide a way to reset the board for a new game.

NON-Functional Requirements:
============================
1. application should be modular and maintainable.
2. The board should be scalable to support different sizes in the future.
3. The code should be scalable.

Entities:
=========
1. Board
2. Player implements PlayerStrategy
3. Game
4. Position
5. Symbol (Enum: X, O, EMPTY)
6. GameState (XTurn, OTurn, Draw, XWin, OWin)
7. GameContext
8. PlayerStrategy

RelationShips:
==================
1. Game has a Board. (Aggregation)
2. Game has two Players. (Aggregation)
3. Game has a GameContext. (Composition)
4. Player has PlayerStrategy. (Composition)
5. Board uses Position and Symbol. (Association)
6. GameContext has a GameState. (Composition)


Entities With State and Behaviors:
==================================
1. Board
   State:
        int rows;
        int columns;
        String[][] grid;
   Behaviors:
        Board(int rows, int columns)
        void displayBoard()
        boolean isValidMove(Position position)
        void makeMove(Position position, Symbols symbol)
        
2. Player implements PlayerStrategy
   State:
        String name;
        Symbol symbol;
   Behaviors:
        Player(String name, Symbol symbol)
        Position makeMove()
        
3. Game
    State:
        Board board;
        Player playerX;
        Player playerO;
        GameContext gameContext;
        Player currentPlayer;
    Behaviors:
        void play()
        void resetGame()
        void switchTurn()
        void announceResult()
        
4. Position
    State:
        int row;
        int column;
    Behaviors:
        Position(int row, int column)
        
5. Symbol (Enum: X, O, EMPTY)

6. GameState (XTurn, OTurn, Draw, XWin, OWin)
    State:
        GameState currentState;
    Behaviors:
        void setState(GameState state)
        GameState getState()
        void next(GameContext context)
        boolean isGameOver()

7. GameContext
    State:
        GameState gameState;
    Behaviors:
        GameContext(XTurn initialState)
        void setState(GameState state)
        GameState getState()
        boolean isGameOver()
        

8. PlayerStrategy
    Behaviors:
        Position makeMove()

Key Patterns USED:
==================
1. State Pattern: To manage the different states of the game (XTurn, OTurn, Draw, XWin, OWin).
2. Strategy Pattern: To define different player strategies for making moves.