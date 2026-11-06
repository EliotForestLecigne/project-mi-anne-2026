package action;

import entity.Character;
import status.Status;

public abstract class Spell extends Action {
    public final int MPcost;

    protected Spell(String name, int mPcost) {
        super(name);
        this.MPcost = mPcost;
    }

    public boolean checkMP(Character attacker){
        return attacker.getCurrentMP()>=MPcost;
    }

    public boolean checkSTOPSPEEL(Character attacker){
        return attacker.getStatusList().containtStatus(Status.STOPSPELL);
    }
}
