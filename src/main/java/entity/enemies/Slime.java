package entity.enemies;

import action.actions.PhysicalAttack;
import entity.Enemie;
import entity.Stat;

import java.util.List;

public class Slime extends Enemie {

    public Slime(String name){
        Stat tempTest = new Stat(5, 0, 5,3,2,50,1);
        this.setName(name);
        this.setStat(tempTest);
        this.setCurrentHP(this.getStat().getMaxHP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setPossibleActions(List.of(new PhysicalAttack()));
        this.setExpGain(10);
    }


}
