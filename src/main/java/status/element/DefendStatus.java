package status.element;

import entity.Character;

public class DefendStatus implements StatusEffect{
    private int tmp;

    @Override
    public void onApply(entity.Character character) {
        tmp = character.getStat().getDefence();
        character.getTempStat().setDefence(tmp + character.getTempStat().getDefence());
    }

    @Override
    public void onRemove(Character character) {
        character.getTempStat().setDefence(character.getTempStat().getDefence() - tmp);
    }
}
