import combat.Combat;
import entity.*;
import entity.Character;
import entity.enemies.Slime;
import util.JsonManager;
import util.RandomManager;
import util.UserInputManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {

        IPlayer player;
            JsonManager<Player> jsonManager = new JsonManager<>(Player.class);
            List<Player> playerJsonList = jsonManager.readAll("save.json");

            if (playerJsonList.isEmpty()){

                player= new Player(UserInputManager.InputName());
            }else {
                player = UserInputManager.InputLoadSave();
            }


        List<IPlayer> playerList = new ArrayList<>();
        playerList.add(player);
        List<IEnemie> enemieList;
        while (true) {
           int choice =  UserInputManager.InputMainMenu();
           switch (choice){
               case 1:
                   enemieList=UserInputManager.InputEncounter();
                   Combat combat = new Combat(playerList, enemieList);
                   combat.begin();
                   break;
               case 2:
                   for (IPlayer player1 : playerList){
                       player1.setCurrentHP(player1.getStat().getMaxHP());
                       player1.setCurrentMP(player1.getStat().getMaxMP());
                   }
                   break;
               case 3:
                   JsonManager<IPlayer> jsonManagerInterface = new JsonManager<>(IPlayer.class);
                   jsonManagerInterface.overwriteWithList("save.json", playerList);
                   break;
               case 4:
                   return;
           }

        }

    }
}
