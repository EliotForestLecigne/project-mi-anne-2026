package action;

import entity.Character;
import entity.ICharacter;
import status.Status;

public interface ISpell extends IAction{
    int getMPcost();

    boolean checkMP(ICharacter attacker);

    boolean checkSTOPSPEEL(ICharacter attacker);
}
