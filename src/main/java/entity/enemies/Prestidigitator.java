package entity.enemies;

import action.actions.PhysicalAttack;
import action.spells.Hurt;
import action.spells.Sleep;
import entity.Enemie;
import entity.Stat;

import java.util.List;

public class Prestidigitator extends Enemie {

    public Prestidigitator(String name){

        this.setName(name);
        this.setStat(new Stat(30, 30, 12,8,1,0,1));
        this.setCurrentHP(this.getStat().getMaxHP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setPossibleActions(List.of(new PhysicalAttack(), new Hurt(), new Sleep()));
        this.setExpGain(100);
    }
}
