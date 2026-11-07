package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import entity.ICharacter;
import status.Status;

import java.util.List;

public class Oomph extends Spell {

    public Oomph() {
        super("Oomph",10);
    }

    @Override
    public ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders) {
        int duration = 4;

        if (!checkMP(attacker)) {
            return ActionResult.NOTENOUGHMP;
        }
        if (checkSTOPSPEEL(attacker)){
            return ActionResult.CANTUSE;
        }

        attacker.setCurrentMP(attacker.getCurrentMP() - MPcost);

        attacker.getStatusList().addStatusDuration(Status.OOMPH, duration, attacker);


        return ActionResult.BOOST;
    }



}
