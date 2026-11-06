package entity;

import action.Action;
import action.IAction;
import status.StatusList;

import java.util.List;

public abstract class Character implements ICharacter{
    private Stat stat;
    private Stat tempStat = new Stat();
    private String name;
    private int currentHP;
    private int currentMP;
    private List<IAction> possibleActions;
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
