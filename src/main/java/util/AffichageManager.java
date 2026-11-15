package util;

import action.Action;
import action.IAction;
import action.ISpell;
import action.Spell;
import combat.Encounters;
import entity.*;
import entity.Character;
import level.Level;
import status.StatusDuration;

import java.util.List;

/// Manage the display of information
public class AffichageManager {

    public AffichageManager() {
    }

    public static void displayAttack(ICharacter attacker, ICharacter defender){
        System.out.printf("%s attack %s \n", attacker.getName(), defender.getName());
    }

    public static void displaySpellOnSelf(ICharacter character, String name){
        System.out.printf("%s use %s on themself \n", character.getName(), name);
    }

    public static void displaySpellOnOther(ICharacter attacker, String name, ICharacter defender){
        System.out.printf("%s use %s on %s  \n", attacker.getName(), name, defender.getName());
    }

    public static void  displaySpellOnOthers(ICharacter attacker, String name, List<ICharacter> defenders){
        System.out.printf("%s cast %s on ", attacker.getName(), name);
        for (ICharacter defender : defenders){
            System.out.printf("%s ",defender.getName());
        }
        System.out.println();
    }

    public static void displayHealed(int HPhealed, ICharacter characterHealed){
        System.out.printf("%s is healed for %d \n", characterHealed.getName(), HPhealed);
    }

    public static void displayDamaged(int damage, ICharacter characterDamaged){
        System.out.printf("%s take %d damage \n", characterDamaged.getName(), damage);
    }

    public static void attackEvaded(ICharacter defender){
        System.out.printf("%s evaded the attack \n", defender.getName());
    }

    public static void battleStart(){
        System.out.printf("The battle start \n");
    }

    public static void turnStart(int turnNumber){
        System.out.printf("Turn %d start \n", turnNumber);
    }

    public static void characterInformation(ICharacter character){
        System.out.printf("%s HP : %d/%d MP: %d/%d ", character.getName(), character.getCurrentHP(),
                character.getStat().getMaxHP(), character.getCurrentMP(), character.getStat().getMaxMP());

        if (character instanceof IPlayer) System.out.printf("level:%d ", ((IPlayer) character).getLevel());

        for (StatusDuration statusDuration : character.getStatusList().getStatusDurations()){
            System.out.printf("%s %d ", statusDuration.getStatus().getName(), statusDuration.getDurationLeft());
        }
        System.out.println();

    }


    public static void AffichagePlayerChooseNextAction(IPlayer player){
        System.out.println("Choose your action :");
        int nb = 1;
        for (IAction action :  player.getPossibleActions()){
            System.out.printf("(%d) ", nb);
            if(action instanceof ISpell){
                AffichageActionInChoose((ISpell) action);
            }else {
                AffichageActionInChoose(action);
            }
            nb++;
        }
    }

    public static void AffichageActionInChoose(IAction action){
        System.out.println(String.format("%s", action.getName()));
    }

    public static void AffichageActionInChoose(ISpell spell){
        System.out.println(String.format("%s MP:%d", spell.getName(),  spell.getMPcost() ));    }

    public  static void AffichageEncounterChoose(List<Encounters> encountersList){
        System.out.println("Choose your fight :");
        int nb = 1;
        for (Encounters encounter : encountersList){
            System.out.printf("(%d) %s\n", nb, encounter.getName());
            nb++;
        }
    }

    public static void displayCharacterFallAslepp(ICharacter character){
        System.out.printf("%s fall asleep \n", character.getName());
    }

    public static void displayCharacterIsSleeping(ICharacter character){
        System.out.printf("%s is sleeping\n", character.getName());
    }

    public static void  dissplayCharacterWakeUp(ICharacter character){
        System.out.printf("%s wake up\n", character.getName());
    }

    public static void displayPlayerGainExp(IPlayer player, int expGain){
        System.out.printf("%s gain %d exp\n", player.getName(), expGain);
    }

    public static void displayPlayerLevelUp(IPlayer player, Level level){
        System.out.printf("%s level up to level %d\n", player.getName(), player.getLevel());
        System.out.print("Gain ");
        Stat stat = level.getStat();
        if (stat.getMaxHP()>0) System.out.printf("%d HP ", stat.getMaxHP());
        if(stat.getMaxMP()>0) System.out.printf("%d MP ", stat.getMaxMP());
        if (stat.getStrength()>0) System.out.printf("%d strength ", stat.getStrength());
        if (stat.getDefence()>0) System.out.printf("%d defence ", stat.getDefence());
        if(stat.getAgility()>0) System.out.printf("%d agility ", stat.getAgility());
        if (stat.getEvasionRate()>0) System.out.printf("%d evasion rate ", stat.getEvasionRate());
        if(stat.getLuck()>0) System.out.printf("%d luck ",stat.getLuck());
        if (level.getAction()!= null) System.out.printf("\n%s learn %s", player.getName(), level.getAction().getName());
        System.out.println();
    }

}
