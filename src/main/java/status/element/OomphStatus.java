package status.element;

import entity.Character;

public class OomphStatus implements StatusEffect{
    private int tmp;

    @Override
    public void onApply(Character character) {
        tmp = character.getStat().getStrength();
        character.getTempStat().setStrength(tmp + character.getTempStat().getStrength());
    }

    @Override
    public void onRemove(Character character) {
        character.getTempStat().setStrength(character.getTempStat().getStrength() - tmp);
    }
}
