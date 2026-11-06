package action.spells;

import action.Action;
import action.ActionResult;
import action.Spell;
import entity.Character;
import entity.ICharacter;
import status.Status;
import util.AffichageManager;
import util.RandomManager;

import java.util.List;

public class Heal extends Spell {
    public String name = "Heal";

    public Heal() {
        super("Heal", 3);
    }


    @Override
    public ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders) {
        if(!checkMP(attacker)){
            return ActionResult.NOTENOUGHMP;
        }
        if(checkSTOPSPEEL(attacker)){
            return ActionResult.CANTUSE;
        }
        attacker.setCurrentMP(attacker.getCurrentMP()-MPcost);

        AffichageManager.displaySpellOnSelf(attacker, name);
        int HPheal = RandomManager.getInstance().getRandomIntBetween(20, 27);
        attacker.setCurrentHP(Math.min( attacker.getCurrentHP() + HPheal, attacker.getStat().getMaxHP()));

        AffichageManager.displayHealed(HPheal,attacker);
        return ActionResult.HEAL;
    }
}
