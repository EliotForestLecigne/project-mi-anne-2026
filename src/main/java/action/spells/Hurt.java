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

public class Hurt extends Spell {
    public String name = "Hurt";

    public Hurt() {
        super("Hurt",5);
    }

    @Override
    public ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders) {
        ICharacter defender = defenders.get(0);

        if(!checkMP(attacker)){
            return ActionResult.NOTENOUGHMP;
        }
        if (checkSTOPSPEEL(attacker)){
            return ActionResult.CANTUSE;
        }

        AffichageManager.displaySpellOnOther(attacker,name,defender);

        attacker.setCurrentMP(attacker.getCurrentMP()-MPcost);
        int damage = RandomManager.getInstance().getRandomIntBetween(20, 27);
        defender.setCurrentHP(Math.max(0, defender.getCurrentHP() - damage));

        AffichageManager.displayDamaged(damage, defender);
        return ActionResult.MAGICDAMAGE;
    }
}
