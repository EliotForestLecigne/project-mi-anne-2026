package action;

import entity.Character;
import entity.ICharacter;
import status.Status;

public abstract class Spell extends Action implements ISpell{
    public final int MPcost;

    protected Spell(String name, int mPcost) {
        super(name);
        this.MPcost = mPcost;
    }

    @Override
    public int getMPcost() {
        return MPcost;
    }

    public boolean checkMP(ICharacter attacker){
        return attacker.getCurrentMP()>=MPcost;
    }

    public boolean checkSTOPSPEEL(ICharacter attacker){
        return attacker.getStatusList().containtStatus(Status.STOPSPELL);
    }
}
