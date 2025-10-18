package org.example;

public class Game
{
    
    private Board board;
    private GameContext gameContext;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    
    public Game(Player playerX, Player playerO)
    {
        this.board = new Board(3, 3);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board.setCell(i, j, Symbol.E);
            }
        }
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
        this.gameContext = new GameContext(new XTurnState());
    }
    
    public void play()
    {
        do {
            board.printBoard();
            Position position = currentPlayer.getStrategy().makeMove(board);
            board.makeMove(position, currentPlayer.getSymbol());
            board.checkGameState(gameContext, currentPlayer);
            switchTurn();
        } while(!this.gameContext.isGameOver());
        announceWinner(currentPlayer == playerX ? playerO : playerX);
    }

    public void resetGame(Player playerX, Player playerO) {
        this.board = new Board(3, 3);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext(new XTurnState());
    }
    
    public void switchTurn() {
        if(this.currentPlayer == playerX) {
            this.currentPlayer = playerO;
        } else {
            this.currentPlayer = playerX;
        }
    }
    
    public void announceWinner(Player player) {
        System.out.println("Player " + player.getSymbol() + " has won the game!");
    }
}
