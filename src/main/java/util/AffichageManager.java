package util;

import action.Action;
import action.Spell;
import combat.Encounters;
import entity.Character;
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

    public static void displayAttack(Character attacker, Character defender){
        System.out.printf("%s attack %s \n", attacker.getName(), defender.getName());
    }

    public static void displaySpellOnSelf(Character character, String name){
        System.out.printf("%s use %s on themself \n", character.getName(), name);
    }

    public static void displaySpellOnOther(Character attacker, String name, Character defender){
        System.out.printf("%s use %s on %s  \n", attacker.getName(), name, defender.getName());
    }

    public static void  displaySpellOnOthers(Character attacker, String name, List<Character> defenders){

    }

    public static void displayHealed(int HPhealed, Character characterHealed){
        System.out.printf("%s is healed for %d \n", characterHealed.getName(), HPhealed);
    }

    public static void displayDamaged(int damage, Character characterDamaged){
        System.out.printf("%s take %d damage \n", characterDamaged.getName(), damage);
    }

    public static void attackEvaded(Character defender){
        System.out.printf("%s evaded the attack \n", defender.getName());
    }

    public static void battleStart(){
        System.out.printf("The battle start \n");
    }

    public static void turnStart(int turnNumber){
        System.out.printf("Turn %d start \n", turnNumber);
    }

    public static void characterInformation(Character character){
        System.out.printf("%s HP : %d/%d MP: %d/%d ", character.getName(), character.getCurrentHP(),
                character.getStat().getMaxHP(), character.getCurrentMP(), character.getStat().getMaxMP());
        for (StatusDuration statusDuration : character.getStatusList().getStatusDurations()){
            System.out.printf("%s %d", statusDuration.getStatus().getName(), statusDuration.getDurationLeft());
        }
        System.out.println();

    }


    public static void AffichagePlayerChooseNextAction(Player player){
        System.out.println("Choisi ton action ce tour :");
        int nb = 1;
        for (Action action :  player.getPossibleActions()){
            System.out.printf("(%d) ", nb);
            if(action instanceof Spell){
                AffichageActionInChoose((Spell) action);
            }else {
                AffichageActionInChoose(action);
            }

            //TODO : use polymorphisme
            nb++;
        }
    }

    public static void AffichageActionInChoose(Action action){
        System.out.println(String.format("%s", action.getName()));
    }

    public static void AffichageActionInChoose(Spell spell){
        System.out.println(String.format("%s MP:%d", spell.getName(),  spell.MPcost ));    }

    public  static void AffichageEncounterChoose(List<Encounters> encountersList){
        System.out.println("Choisi ton combat :");
        int nb = 1;
        for (Encounters encounter : encountersList){
            System.out.printf("(%d) %s\n", nb, encounter.getName());
        }
    }

}
