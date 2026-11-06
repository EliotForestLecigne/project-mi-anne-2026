package action;

import entity.Character;
import entity.ICharacter;

import java.util.List;

public interface IAction {

    String getName();

    ActionResult actionActivation(ICharacter attacker, List<ICharacter> defenders);
}
