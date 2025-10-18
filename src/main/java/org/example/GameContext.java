package org.example;

public class GameContext
{

    private GameState state;

    public GameContext(GameState state)
    {
        this.state = state;
    }

    public void setState(GameState state)
    {
        this.state = state;
    }

    public void next(Player player, boolean hasWon)
    {
        state.next(player, this, hasWon);
    }

    public boolean isGameOver()
    {
        return state.isGameOver();
    }
}
