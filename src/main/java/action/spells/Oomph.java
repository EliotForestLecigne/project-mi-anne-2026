package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import status.Status;

import java.util.List;

public class Oomph extends Spell {

    public Oomph() {
        super("Oomph",10);
    }

    @Override
    public ActionResult actionActivation(entity.Character attacker, List<Character> defenders) {
        int duration = 4;

        if (!checkMP(attacker)) {
            return ActionResult.NOTENOUGHMP;
        }

        attacker.setCurrentMP(attacker.getCurrentMP() - MPcost);

        attacker.getStatusList().addStatusDuration(Status.OOMPH, duration, attacker);


        return ActionResult.BOOST;
    }



}
