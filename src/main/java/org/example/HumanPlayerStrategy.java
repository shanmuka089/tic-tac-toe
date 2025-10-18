package org.example;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy
{
    
    private String name;
    Scanner scanner = new Scanner(System.in);
    
    public HumanPlayerStrategy(String name)
    {
        this.name = name;
    }

    @Override
    public Position makeMove(Board board)
    {
        System.out.println(name + ", it's your turn. You are playing");
        System.out.println("Enter your move row: ");
        int row = scanner.nextInt();
        System.out.println("Enter your move column: ");
        int column = scanner.nextInt();

        if(board.isValidMove(row, column)) {
            return new Position(row, column);
        } else {
            System.out.println("Invalid move. Try again.");
            return makeMove(board);
        }
    }
}
