package testingclasses;

import entity.Enemie;
import entity.Stat;

public class TesterEnemie extends Enemie {
    public TesterEnemie(){
        this.setName("Tester Enemie");
        this.setPossibleActions(null);
        this.setStat(new Stat(100,100,10,10,10,0,0));
        this.setCurrentHP(this.getStat().getMaxMP());
        this.setCurrentMP(this.getStat().getMaxMP());
    }

}
