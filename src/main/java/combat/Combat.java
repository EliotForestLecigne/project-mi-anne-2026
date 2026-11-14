package combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.sun.tools.javac.Main;
import entity.*;
import entity.Character;
import status.Status;
import util.AffichageManager;

/// Manage the combat between the players and enemies
public class Combat {

    /// The players
    private List<IPlayer> playerList;
    /// The enemies
    private List<IEnemie> enemieList;
    /// The players + enemies
    private List<ICharacter> characterList;

    /// Check if a battle is ended or not
    private boolean battleStop = false;

    /// Check if the battle was lost or won
    private boolean battleLost = false;

    /// Turn number (used only for display)
    private int turnNumber = 1;

    /// Start the battle till it stop
    public void begin(){
        while (!battleStop){
            turn();
        }
    }

    public void turn(){

        AffichageManager.turnStart(turnNumber);

        // Decide the turn order by the combine agility of each character
        characterList.sort(Comparator.comparingInt(a -> a.getStat().getAgility() + a.getTempStat().getAgility()));
        characterList = characterList.reversed();

        for(ICharacter character : characterList){
            AffichageManager.characterInformation(character);
        }

        //Player input for next attack
        ((IPlayer) characterList.stream().filter(character -> character instanceof IPlayer).findFirst().get()).choseNextMove();

        for(ICharacter character : characterList){
            //Character doesnt act if is sleeping
            if(character.getStatusList().containtStatus(Status.SLEEP)){
                AffichageManager.displayCharacterIsSleeping(character);
                break;
            }
            //Character act only if HP positive (is alive)
            if(character.getCurrentHP()>0){
                character.nextMove(characterList);
            }
        }

        turnNumber++;

        endTurn();
    }


    /// Check every change in the end turn (status, victory/loss condition)
    public void endTurn(){
        //Status effect on a endTurn
        for (ICharacter character : characterList){
            character.getStatusList().turnEnd(character);
        }

        //calculate the number of player/enemie with HP>0
        //need to replace with better implementation
        characterList.removeIf(character -> character.getCurrentHP() <= 0);
        long enemieCount = enemieList.stream().filter(enemie -> enemie.getCurrentHP() > 0).count();
        long playerCount = playerList.stream().filter(player -> player.getCurrentHP() > 0).count();

        //If no player or no enemie still alive battle end
        if(playerCount ==0){
            battleStop = true;
            //battle lost
            this.battleLost();
        }
        if (enemieCount==0){
            battleStop=true;
            //battle win
            battleWon();
        }
    }

    /// Game over
    public void battleLost(){
        System.out.println("GAME OVER");

        battleLost=true;
    }

    ///battle won
    /// player gain exp and possibly level up
    public void battleWon(){

        System.out.println("BATTLE WON");

        int expGain = enemieList.stream().mapToInt(IEnemie::getExpGain).sum();
        for (IPlayer player : playerList){
            player.setExpCount(player.getExpCount() + expGain);

            AffichageManager.displayPlayerGainExp(player, expGain);

            player.levelUp();
        }
    }

    public Combat(List<IPlayer> playerList, List<IEnemie> enemieList) {
        this.playerList=playerList;
        this.enemieList=enemieList;
        this.characterList = new ArrayList<>();
        characterList.addAll(playerList);
        characterList.addAll(enemieList);
    }

    public List<ICharacter> getCharacterList() {
        return characterList;
    }

    public boolean isBattleLost() {
        return battleLost;
    }
}
