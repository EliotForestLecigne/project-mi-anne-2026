package entity.enemies;

import action.actions.PhysicalAttack;
import entity.Enemie;
import entity.Stat;

import java.util.List;

public class Slime extends Enemie {

    public Slime(String name){
        Stat tempTest = new Stat(100, 0, 10,1,1,0,1);
        this.setName(name);
        this.setStat(tempTest);
        this.setCurrentHP(this.getStat().getMaxHP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setPossibleActions(List.of(new PhysicalAttack()));
        this.setExpGain(1);
    }


}
