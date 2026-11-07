package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import entity.ICharacter;
import status.Status;
import status.StatusDuration;
import util.AffichageManager;

import java.util.List;

public class Sleep extends Spell {
    public Sleep() {
        super("Sleep",10);
    }

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

        AffichageManager.displaySpellOnOthers(attacker, this.getName(), defenders);

        for (ICharacter defender : defenders){
            defender.getStatusList().addStatusDuration(Status.SLEEP, duration, defender);

        }


        return ActionResult.STATUSAFFLICTED;
    }



}
