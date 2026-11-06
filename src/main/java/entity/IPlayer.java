package entity;

import action.Action;
import action.IAction;
import util.UserInputManager;

public interface IPlayer extends ICharacter{
    void gainExp(int expCount);

    void levelUp();

    void choseNextMove();

    void setNextAction(IAction nextAction);

    int getExpCount();

    void setExpCount(int expCount);
}
