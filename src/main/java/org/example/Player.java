package org.example;

import java.util.Scanner;

public class Player
{
    private Symbol symbol;
    
    private PlayerStrategy strategy;
    
    public Player(String name, Symbol symbol)
    {
        this.symbol = symbol;
        this.strategy = new HumanPlayerStrategy(name);
    }
    
    public Symbol getSymbol()
    {
        return symbol;
    }
    
    public PlayerStrategy getStrategy() {
        return strategy;
    }
}
