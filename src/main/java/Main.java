import combat.Combat;
import entity.*;
import entity.Character;
import entity.enemies.Slime;
import util.RandomManager;
import util.UserInputManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Player player = new Player();
        List<IPlayer> playerList = new ArrayList<>();
        playerList.add(player);
        List<IEnemie> enemieList = UserInputManager.InputEncounter();
        Combat combat = new Combat(playerList, enemieList);
        combat.begin();

    }
}
