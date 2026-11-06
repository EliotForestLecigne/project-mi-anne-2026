package util;

import action.Action;
import combat.Encounters;
import entity.Enemie;
import entity.Player;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class UserInputManager {
    public static Action InputPlayerAction(Player player){

        AffichageManager.AffichagePlayerChooseNextAction(player);

        Scanner scanner= new Scanner(System.in);


        boolean valideImput = false;

        Action action = null;

        while (!valideImput){
            System.out.println("Enter choice :");
            int choise = scanner.nextInt();

            if( 0 < choise && choise -1 < player.getPossibleActions().size()){
                valideImput = true;
                action = player.getPossibleActions().get(choise-1);

            }
            else {
                System.out.println("Invalide Imput");
            }
        }
        return action;
    }

    public  static List<Enemie> InputEncounter(){
        Scanner scanner= new Scanner(System.in);

        List<Encounters> encountersList = new ArrayList<>(EnumSet.allOf(Encounters.class));

        boolean valideImput = false;

        List<Enemie> enemieList = null;

        AffichageManager.AffichageEncounterChoose(encountersList);

        while (!valideImput){
            System.out.println("Enter choice :");
            int choise = scanner.nextInt();
            if( 0 < choise && choise -1 < encountersList.size()){
                valideImput = true;
                enemieList = encountersList.get(choise-1).getEnemies();

            }
            else {
                System.out.println("Invalide Imput");
            }
        }
        return enemieList;
    }
}
