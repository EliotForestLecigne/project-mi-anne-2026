package level;

import action.IAction;
import entity.Stat;
import status.Status;

public class Level {
    private Stat stat;
    private IAction action;
    private int levelNb;
    private int expThreshold;

    public Level(Stat stat, IAction action, int levelNb, int expThreshold) {
        this.stat = stat;
        this.action = action;
        this.levelNb = levelNb;
        this.expThreshold = expThreshold;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public int getLevelNb() {
        return levelNb;
    }

    public void setLevelNb(int levelNb) {
        this.levelNb = levelNb;
    }

    public int getExpThreshold() {
        return expThreshold;
    }

    public void setExpThreshold(int expThreshold) {
        this.expThreshold = expThreshold;
    }
}
