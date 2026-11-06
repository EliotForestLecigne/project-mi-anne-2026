package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import status.Status;
import status.StatusDuration;

import java.util.List;

public class Sleep extends Spell {
    protected Sleep() {
        super("Sleep",10);
    }

    @Override
    public ActionResult actionActivation(entity.Character attacker, List<Character> defenders) {
        int duration = 3;

        if(!checkMP(attacker)){
            return ActionResult.NOTENOUGHMP;
        }

        attacker.setCurrentMP(attacker.getCurrentMP()-MPcost);

        for (Character defender : defenders){
            if(defender.getStatusList().containtStatus(Status.SLEEP)){
                StatusDuration sleepStatus = defender.getStatusList().getStatusDurationOfStatus(Status.SLEEP);
                sleepStatus.setDurationLeft(sleepStatus.getDurationLeft()+duration);
            }else {
                defender.getStatusList().addStatusDuration(Status.SLEEP, duration, defender);
            }
        }


        return ActionResult.STATUSAFFLICTED;
    }



}
