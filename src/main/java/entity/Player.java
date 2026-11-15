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
import level.Level;
import level.LevelList;
import util.AffichageManager;
import util.JsonManager;
import util.UserInputManager;
import util.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/// Extension of a character controllable by the user and that can level up
public class Player extends Character implements IPlayer{

    /// Current level
    private int level;
    /// Total of exp gained
    private int expCount;
    /// Stockage of the action selected by the user
    private IAction nextAction;
    /// The levels of the player that they can gain
    private LevelList levelList;

    public Player(){
        //default state
        level=1;
        expCount=0;
        this.setName("Hero");
        this.setStat(new Stat(100, 100, 10, 1, 2, 1, 10));
        this.setCurrentHP(this.getStat().getMaxHP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setPossibleActions(new ArrayList<>(Arrays.asList(new PhysicalAttack(), new Heal(), new Hurt(), new Defend(), new Oomph(), new Sleep())));

        JsonManager<LevelList> json = new JsonManager<>(LevelList.class);
        levelList =  json.readAll("PlayerLevels.json").get(0);

    }

    public Player(String name){
        //default state
        level=1;
        expCount=0;
        this.setName(name);
        this.setStat(new Stat(10, 0, 10, 1, 2, 1, 10));
        this.setCurrentHP(this.getStat().getMaxHP());
        this.setCurrentMP(this.getStat().getMaxMP());
        this.setPossibleActions(new ArrayList<>(Arrays.asList(new PhysicalAttack(), new Defend(), new Oomph())));


        JsonManager<LevelList> json = new JsonManager<>(LevelList.class);
        List<LevelList> result = null;
        try {
            result =  json.readAll("PlayerLevels.json");
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
            return;
        }
        this.levelList=result.get(0);


    }

    public void gainExp(int expCount){
        setExpCount(expCount + getExpCount());

    }

    /// Level sequence
    public void levelUp(){
        // verify if the next level exist then if the exp threshold as been past
        //if yes then gain the stat and move stock in the level
        if (levelList.levelExist(level+1)){
            Level levelGain = levelList.giveNbLevel(level+1);
            if(levelGain.getExpThreshold()<=expCount){
                level++;
                this.getStat().addStat(levelGain.getStat());
                this.setCurrentHP(this.getCurrentHP() + levelGain.getStat().getMaxHP());
                this.setCurrentMP(this.getCurrentMP() + levelGain.getStat().getMaxMP());

                if (levelGain.getAction()!=null){
                    this.getPossibleActions().add(levelGain.getAction());
                }

                AffichageManager.displayPlayerLevelUp(this, levelGain);

                this.levelUp(); // in the case of multiple levelUp after one fight
            }
        }
    }

    /// Ask the user for the next action
    public void choseNextMove(){


        nextAction = UserInputManager.InputPlayerAction(this);


    }

    /// Activate the action stock in nextAction
    @Override
    public void nextMove(List<ICharacter> characterList) {
        //need change if multiple players in a combat
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

    public int getLevel() {
        return level;
    }


}
