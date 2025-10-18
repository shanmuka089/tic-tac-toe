package org.example;

public class OWonState implements GameState
{


    @Override
    public void next(Player player, GameContext gameContext, boolean hasWon)
    {
        System.out.println("Game is over. O has already won.");
    }

    @Override
    public boolean isGameOver()
    {

        return true;
    }

}
