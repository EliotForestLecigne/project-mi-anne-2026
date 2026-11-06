package status.element;

import entity.Character;

public interface StatusEffect {
    public void onApply(Character character);
    public void onRemove(Character character);
}
