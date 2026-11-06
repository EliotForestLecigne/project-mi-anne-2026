package action;

import entity.Character;

import java.util.List;

public abstract class Action {
    private String name;

    public Action(String name) {
        this.name = name;
    }


    public String getName(){
        return name;
    }

   public abstract ActionResult actionActivation(Character attacker, List<Character> defenders);
}
