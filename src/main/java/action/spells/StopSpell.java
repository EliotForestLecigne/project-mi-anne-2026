package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import status.Status;
import status.StatusDuration;

import java.util.List;

public class StopSpell extends Spell{


    protected StopSpell() {
        super("Stop Spell", 10);
    }

    @Override
    public ActionResult actionActivation(entity.Character attacker, List<Character> defenders) {

        int duration = 3;

        if(!checkMP(attacker)){
            return ActionResult.NOTENOUGHMP;
        }

        attacker.setCurrentMP(attacker.getCurrentMP()-MPcost);

        for (entity.Character defender : defenders){
            if(defender.getStatusList().containtStatus(Status.STOPSPELL)){
                StatusDuration sleepStatus = defender.getStatusList().getStatusDurationOfStatus(Status.SLEEP);
                sleepStatus.setDurationLeft(sleepStatus.getDurationLeft()+duration);
            }else {
                defender.getStatusList().addStatusDuration(Status.STOPSPELL, duration, defender);
            }
        }


        return ActionResult.STATUSAFFLICTED;
    }

}
