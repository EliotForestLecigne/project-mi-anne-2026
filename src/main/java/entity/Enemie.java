package entity;

import action.Action;
import action.IAction;
import util.RandomManager;

import java.util.List;

/// Extension of a character non-controllable by the User
public class Enemie extends Character implements IEnemie{
    /// The exp given when defeated
    private int expGain;

    /// Choose its next move at random and used it
    @Override
    public void nextMove(List<ICharacter> characterList) {
        List<ICharacter> defenders = characterList.stream().filter(character -> character instanceof Player).toList();

        int moveNb = RandomManager.getInstance().getRandomIntBetween(0, this.getPossibleActions().size());
        IAction action = this.getPossibleActions().get(moveNb);

        action.actionActivation(this, defenders);
    }

    public int getExpGain() {
        return expGain;
    }

    public void setExpGain(int expGain) {
        this.expGain = expGain;
    }
}
