package action;

import action.actions.Defend;
import action.actions.PhysicalAttack;
import action.spells.*;


/// List the different Action possible to decrypt the different json
public enum ActionEnum {

STOPSPELL(new StopSpell(), new StopSpell().getName()),
DEFEND(new Defend(), new Defend().getName()),
    PHYSICALATTACK(new PhysicalAttack(),new PhysicalAttack().getName()),
    HEAL(new Heal(),new Heal().getName()),
    HURT(new Hurt(),new Hurt().getName()),
    OOMPH(new Oomph(),new Oomph().getName()),
    SLEEP(new Sleep(),new Sleep().getName()),

    ;

    private IAction action;
    private String name;

    ActionEnum(IAction action, String name) {
        this.action = action;
        this.name = name;
    }

    public IAction getAction() {
        return action;
    }

    public String getName() {
        return name;
    }
}
