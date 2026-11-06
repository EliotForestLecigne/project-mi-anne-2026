package status.element;

import entity.Character;
import entity.ICharacter;

public class DefendStatus implements StatusEffect{
    private int tmp;

    @Override
    public void onApply(ICharacter character) {
        tmp = character.getStat().getDefence();
        character.getTempStat().setDefence(tmp + character.getTempStat().getDefence());
    }

    @Override
    public void onRemove(ICharacter character) {
        character.getTempStat().setDefence(character.getTempStat().getDefence() - tmp);
    }
}
