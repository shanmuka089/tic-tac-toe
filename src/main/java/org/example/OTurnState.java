package org.example;

public class OTurnState implements GameState
{
    @Override
    public void next(Player player, GameContext gameContext, boolean hasWon)
    {
        if(hasWon) {
            if(player.getSymbol() == Symbol.O)
            {
                gameContext.setState(new OWonState());
            } else
            {
                gameContext.setState(new XWonState());
            }
        } else {
            gameContext.setState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver()
    {

        return false;
    }

}
