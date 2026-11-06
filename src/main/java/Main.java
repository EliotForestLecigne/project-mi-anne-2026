import combat.Combat;
import entity.Character;
import entity.Enemie;
import entity.Player;
import entity.enemies.Slime;
import util.RandomManager;
import util.UserInputManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Player player = new Player();
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        List<Enemie> enemieList = UserInputManager.InputEncounter();
        Combat combat = new Combat(playerList, enemieList);
        combat.begin();

    }
}
