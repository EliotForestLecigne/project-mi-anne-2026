package entity;

import action.Action;
import action.IAction;
import status.StatusList;

import java.util.List;

/// Structure of a element in battle
public abstract class Character implements ICharacter{
    /// Stat to calculate damage and resources like HP/MP
    private Stat stat;
    /// Temporary stat for buff/debuff
    private Stat tempStat = new Stat();
    /// name/identification
    private String name;
    /// Current resources
    private int currentHP;
    private int currentMP;
    /// Action usable by the character
    private List<IAction> possibleActions;
    /// The status currently present on the character
    private StatusList statusList = new StatusList();



    public abstract void nextMove(List<ICharacter> characterList);

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }


    public StatusList getStatusList() {
        return statusList;
    }

    public void setStatusList(StatusList statusList) {
        this.statusList = statusList;
    }

    public Stat getTempStat() {
        return tempStat;
    }

    public void setTempStat(Stat tempStat) {
        this.tempStat = tempStat;
    }

    public List<IAction> getPossibleActions() {
        return possibleActions;
    }

    public void setPossibleActions(List<IAction> possibleActions) {
        this.possibleActions = possibleActions;
    }

    public void setName(String name) {
        this.name = name;
    }
}
