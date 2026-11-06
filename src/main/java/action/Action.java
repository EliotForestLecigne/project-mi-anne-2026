package action;

import entity.Character;
import entity.ICharacter;


import java.util.List;

public abstract class Action implements IAction {
    private String name;

    public Action(String name) {
        this.name = name;
    }


    public String getName(){
        return name;
    }

   public abstract ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders);
}
