package status.element;

import entity.Character;
import entity.ICharacter;

public class OomphStatus implements StatusEffect{
    private int tmp;

    @Override
    public void onApply(ICharacter character) {
        tmp = character.getStat().getStrength();
        character.getTempStat().setStrength(tmp + character.getTempStat().getStrength());
    }

    @Override
    public void onRemove(ICharacter character) {
        character.getTempStat().setStrength(character.getTempStat().getStrength() - tmp);
    }
}
