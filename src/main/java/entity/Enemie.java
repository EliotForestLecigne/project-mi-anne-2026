package entity;

import action.Action;
import util.RandomManager;

import java.util.List;

public class Enemie extends Character{
    private int expGain;

    @Override
    public void nextMove(List<Character> characterList) {
        List<Character> defenders = characterList.stream().filter(character -> character instanceof Player).toList();

        int moveNb = RandomManager.getInstance().getRandomIntBetween(0, this.getPossibleActions().size());
        Action action = this.getPossibleActions().get(moveNb);

        action.actionActivation(this, defenders);
    }

    public int getExpGain() {
        return expGain;
    }

    public void setExpGain(int expGain) {
        this.expGain = expGain;
    }
}
