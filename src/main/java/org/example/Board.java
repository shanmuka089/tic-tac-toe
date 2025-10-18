package org.example;

public class Board
{
    private int rows;
    private int columns;
    private Symbol[][] grid;
    
    public Board(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];
    }
    
    public void setCell(int row, int column, Symbol value)
    {
        grid[row][column] = value;
    }
    
    public boolean isValidMove(int row, int column) {
        if(row < 0 || row >= rows || column < 0 || column >= columns) {
            return false;
        } else if(grid[row][column] != Symbol.E) {
            return false;
        } else {
            return true;
        }
    } 
    
    public void makeMove(Position position, Symbol value)
    {
        if(!isValidMove(position.getRow(), position.getColumn())) {
            throw new IllegalArgumentException("Invalid move: Cell is either out of bounds or already occupied.");
        }
        grid[position.getRow()][position.getColumn()] = value;
    }
    
    public void printBoard()
    {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void checkGameState(GameContext gameContext, Player currentPlayer) {
        
        for(int i = 0; i < rows; i++) {
            if(grid[i][0] != Symbol.E && isWinningLine(grid[i])) {
                gameContext.next(currentPlayer, true);
                return;
            }
        }
        
        for(int i = 0; i < columns; i++) {
            Symbol[] columnLine = new Symbol[rows];
            for(int j = 0; j < rows; j++) {
                columnLine[j] = grid[j][i];
            }
            if(columnLine[0] != Symbol.E && isWinningLine(columnLine)) {
                gameContext.next(currentPlayer, true);
                return;
            }
        }
        
        Symbol[] diag1 = new Symbol[rows];
        Symbol[] diag2 = new Symbol[rows];
        for(int i = 0; i < rows; i++) {
            diag1[i] = grid[i][i];
            diag2[i] = grid[i][rows - i - 1];
        }
        if(diag1[0] != Symbol.E && isWinningLine(diag1)) {
            gameContext.next(currentPlayer, true);
            return;
        }
        
        if(diag2[0] != Symbol.E && isWinningLine(diag2)) {
            gameContext.next(currentPlayer, true);
            return;
        }
        
    }
    
    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for(Symbol cell : line) {
            if(cell != first) {
                return false;
            }
        }
        return true;
    }
}
