package org.example;

public interface GameState
{
    void next(Player player, GameContext gameContext, boolean hasWon);
    boolean isGameOver();
}
