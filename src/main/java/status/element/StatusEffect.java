package status.element;

import action.IAction;
import entity.Character;
import entity.ICharacter;

public interface StatusEffect {
    public void onApply(ICharacter character);
    public void onRemove(ICharacter character);
}
