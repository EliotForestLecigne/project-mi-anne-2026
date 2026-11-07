package testingclasses;

import action.IAction;
import action.actions.PhysicalAttack;
import entity.ICharacter;
import entity.IPlayer;
import entity.Player;
import entity.Stat;
import status.StatusList;

import java.util.List;

public class TesterPlayer extends Player
{
    public TesterPlayer(){
        this.setStat(new Stat(100,100,10,10,0,0,0));
        this.setTempStat(new Stat());
        this.setCurrentHP(this.getStat().getMaxMP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setName("Tester Player");
        this.setPossibleActions(null);
    }

    @Override
    public void choseNextMove() {
        setNextAction(new PhysicalAttack());
    }
}
