package util;

import action.Action;
import action.IAction;
import combat.Encounters;
import entity.Enemie;
import entity.IEnemie;
import entity.IPlayer;
import entity.Player;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

/// Manage the user input and lecture
public class UserInputManager {
    public static IAction InputPlayerAction(IPlayer player){

        AffichageManager.AffichagePlayerChooseNextAction(player);

        Scanner scanner= new Scanner(System.in);


        boolean valideImput = false;

        IAction action = null;

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

    public  static List<IEnemie> InputEncounter(){
        Scanner scanner= new Scanner(System.in);

        List<Encounters> encountersList = new ArrayList<>(EnumSet.allOf(Encounters.class));

        boolean valideImput = false;

        List<IEnemie> enemieList = null;

        AffichageManager.AffichageEncounterChoose(encountersList);

        while (!valideImput){
            System.out.println("Enter choice :");
            int choise = scanner.nextInt();
            if( 0 < choise && choise -1 < encountersList.size()){
                    enemieList = new ArrayList(encountersList.get(choise-1).getEnemies());
                    valideImput=true;
            }
            else {
                System.out.println("Invalide Imput");
            }
        }
        return enemieList;
    }

    public static IPlayer InputLoadSave(){
        Scanner scanner= new Scanner(System.in);
        boolean valideImput = false;

        IPlayer player = null;

        System.out.print("(1) New game\n" +
                "(2) Load save");

        while (!valideImput){
            System.out.println("Enter choice :");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    String name = InputName();
                    player = new Player(name);
                    valideImput=true;
                    break;
                case 2:
                    JsonManager<Player> jsonManager = new JsonManager<>(Player.class);
                    player = jsonManager.readAll("save.json").get(0);
                    valideImput= true;
                    break;
                default:
                    System.out.println("Invalide Imput");
                    break;
            }
        }
        return player;
    }

    public static String InputName(){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter name");

        return scanner.nextLine();
    }

    public static int InputMainMenu(){
        Scanner scanner= new Scanner(System.in);
        boolean valideImput = false;

        IPlayer player = null;

        System.out.print("(1) Next fight\n" +
                "(2) Heal\n" +
                "(3) Save\n" +
                "(4) Quit");

        while (!valideImput){
            System.out.println("Enter choice :");
            int choice = scanner.nextInt();
            if(choice <= 4 && choice>=1){
                return choice;
            }
        }
        return -1;
    }
}
