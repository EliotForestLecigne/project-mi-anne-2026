package entity;

import action.Action;
import action.IAction;
import action.Spell;
import action.actions.Defend;
import action.actions.PhysicalAttack;
import action.spells.Heal;
import action.spells.Hurt;
import action.spells.Oomph;
import action.spells.Sleep;
import util.UserInputManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player extends Character implements IPlayer{
    private int level;
    private int expCount;
    private IAction nextAction;

    public Player(){
        //default state
        level=1;
        expCount=0;
        this.setName("Hero");
        this.setStat(new Stat(100, 100, 10, 1, 2, 1, 10));
        this.setCurrentHP(this.getStat().getMaxHP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setPossibleActions(new ArrayList<>(Arrays.asList(new PhysicalAttack(), new Heal(), new Hurt(), new Defend(), new Oomph(), new Sleep())));
    }

    public void gainExp(int expCount){
        setExpCount(expCount + getExpCount());

    }

    public void levelUp(){
        //check level and seach file
        int maxHP = 0;
        int maxMP = 0;
        int strength = 0;
        int defence = 0;
        int agility = 0;
        int evesionRate = 0;
        this.getStat().addStat(maxHP,maxMP,strength,defence,agility,evesionRate);

    }

    public void choseNextMove(){


        nextAction = UserInputManager.InputPlayerAction(this);


    }

    @Override
    public void nextMove(List<ICharacter> characterList) {
        //TODO temp implemetation
         //characterList.remove(this);
         List<ICharacter> defenders = new ArrayList<>(characterList);
         defenders.remove(this);
        nextAction.actionActivation(this, defenders);
    }

    public void setNextAction(IAction nextAction) {
        this.nextAction = nextAction;
    }

    public int getExpCount() {
        return expCount;
    }

    public void setExpCount(int expCount) {
        this.expCount = expCount;
    }
}
