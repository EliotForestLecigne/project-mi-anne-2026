package action.actions;

import action.Action;
import action.ActionResult;
import entity.Character;
import entity.ICharacter;
import util.AffichageManager;
import util.RandomManager;

import java.util.List;

public class PhysicalAttack extends Action {
    public PhysicalAttack() {
        super("Physical Attack");
    }

    @Override
    public ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders) {

        ICharacter defender = defenders.get(0);

        AffichageManager.displayAttack(attacker, defender);

        if(defender.getStat().getEvasionRate() > RandomManager.getInstance().getRandomIntBetween(0,100)){
            AffichageManager.attackEvaded(defender);
            return ActionResult.EVADED;
        }


        int damage = Math.round(
                ((float) (attacker.getStat().getStrength() + attacker.getTempStat().getStrength())
                        - ((float) (defender.getStat().getDefence() + defender.getTempStat().getDefence()) / 2))
                        / RandomManager.getInstance().getRandomFloatBetween(2.0F, 4.0F));


        damage = Math.max(damage,0);

        AffichageManager.displayDamaged(damage,defender);

        defender.setCurrentHP(Math.max(defender.getCurrentHP()-damage, 0));

        return ActionResult.PHYSICALDAMAGE;
    }
}
