package status;

import status.element.*;

public enum Status {
    SLEEP("sleep", new SleepStatus()),
    STOPSPELL("stopspell", new StopSpellStatus()),
    OOMPH("oohmph", new OomphStatus()),
    DEFEND("defend", new DefendStatus())



    ;

    private Status(String name, StatusEffect statusEffect){
        this.name=name;
        this.statusEffect=statusEffect;
    }
    private String name;
    private StatusEffect statusEffect;

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public String getName() {
        return name;
    }
}
