package util;

import action.Action;
import action.IAction;
import action.ISpell;
import action.Spell;
import combat.Encounters;
import entity.Character;
import entity.ICharacter;
import entity.IPlayer;
import entity.Player;
import status.StatusDuration;

import java.util.List;

public class AffichageManager {
//    private static AffichageManager Instance;

    public AffichageManager() {
    }

//    public static AffichageManager getInstance() {
//        if(Instance == null){
//            return new AffichageManager();
//        }
//        return Instance;
//    }

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
        for (StatusDuration statusDuration : character.getStatusList().getStatusDurations()){
            System.out.printf("%s %d", statusDuration.getStatus().getName(), statusDuration.getDurationLeft());
        }
        System.out.println();

    }


    public static void AffichagePlayerChooseNextAction(IPlayer player){
        System.out.println("Choisi ton action ce tour :");
        int nb = 1;
        for (IAction action :  player.getPossibleActions()){
            System.out.printf("(%d) ", nb);
            if(action instanceof ISpell){
                AffichageActionInChoose((ISpell) action);
            }else {
                AffichageActionInChoose(action);
            }

            //TODO : use polymorphisme
            nb++;
        }
    }

    public static void AffichageActionInChoose(IAction action){
        System.out.println(String.format("%s", action.getName()));
    }

    public static void AffichageActionInChoose(ISpell spell){
        System.out.println(String.format("%s MP:%d", spell.getName(),  spell.getMPcost() ));    }

    public  static void AffichageEncounterChoose(List<Encounters> encountersList){
        System.out.println("Choisi ton combat :");
        int nb = 1;
        for (Encounters encounter : encountersList){
            System.out.printf("(%d) %s\n", nb, encounter.getName());
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

}
