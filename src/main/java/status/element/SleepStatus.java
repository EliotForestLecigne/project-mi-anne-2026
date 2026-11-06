package status.element;

import action.IAction;
import entity.Character;
import entity.ICharacter;
import util.AffichageManager;

public class SleepStatus implements StatusEffect {
    @Override
    public void onApply(ICharacter character) {
        AffichageManager.displayCharacterFallAslepp(character);
    }

    @Override
    public void onRemove(ICharacter character) {
        AffichageManager.dissplayCharacterWakeUp(character);
    }
}
