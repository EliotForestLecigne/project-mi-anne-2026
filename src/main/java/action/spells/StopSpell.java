package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import entity.ICharacter;
import status.Status;
import status.StatusDuration;

import java.util.List;

public class StopSpell extends Spell{


    public StopSpell() {
        super("Stop Spell", 10);
    }

    /// Give the STOPSPELL status to every defender in defenders for 3 turn at a 10 MPcost
    @Override
    public ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders) {

        int duration = 3;

        if(!checkMP(attacker)){
            return ActionResult.NOTENOUGHMP;
        }
        if(checkSTOPSPEEL(attacker)){
            return ActionResult.CANTUSE;
        }

        attacker.setCurrentMP(attacker.getCurrentMP()-MPcost);

        for (ICharacter defender : defenders){
            defender.getStatusList().addStatusDuration(Status.STOPSPELL, duration, defender);
        }


        return ActionResult.STATUSAFFLICTED;
    }

}
