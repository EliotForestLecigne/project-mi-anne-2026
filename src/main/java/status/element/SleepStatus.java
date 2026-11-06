package status.element;

import entity.Character;
import util.AffichageManager;

public class SleepStatus implements StatusEffect {
    @Override
    public void onApply(Character character) {
        AffichageManager.displayCharacterFallAslepp(character);
    }

    @Override
    public void onRemove(Character character) {
        AffichageManager.dissplayCharacterWakeUp(character);
    }
}
