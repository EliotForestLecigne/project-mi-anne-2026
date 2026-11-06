package action.actions;

import action.Action;
import action.ActionResult;
import entity.Character;
import status.Status;

import java.util.List;

public class Defend extends Action {
    public Defend() {
        super("Defend");
    }

    @Override
    public ActionResult actionActivation(Character attacker, List<Character> defenders) {


        attacker.getStatusList().addStatusDuration(Status.DEFEND, 1, attacker);


        return ActionResult.BOOST;
    }
}
