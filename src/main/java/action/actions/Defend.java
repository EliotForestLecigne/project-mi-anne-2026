package action.actions;

import action.Action;
import action.ActionResult;
import entity.Character;
import entity.ICharacter;
import status.Status;

import java.util.List;

public class Defend extends Action {
    public Defend() {
        super("Defend");
    }

    @Override
    public ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders) {


        attacker.getStatusList().addStatusDuration(Status.DEFEND, 1, attacker);


        return ActionResult.BOOST;
    }
}
