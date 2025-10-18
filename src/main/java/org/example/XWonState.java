package org.example;

public class XWonState implements GameState
{


    @Override
    public void next(Player player, GameContext gameContext, boolean hasWon)
    {
        System.out.println("Game is over. X has already won.");
    }

    @Override
    public boolean isGameOver()
    {
        return true;
    }

}
