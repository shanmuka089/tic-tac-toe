package org.example;

public class XTurnState implements GameState
{
    
    @Override
    public void next(Player player, GameContext gameContext, boolean hasWon)
    {
        if(hasWon) {
            if(player.getSymbol() == Symbol.X)
            {
                gameContext.setState(new XWonState());
            } else
            {
                gameContext.setState(new OWonState());
            }
        } else {
            gameContext.setState(new OTurnState());
        }
        
    }

    @Override
    public boolean isGameOver()
    {

        return false;
    }

}
