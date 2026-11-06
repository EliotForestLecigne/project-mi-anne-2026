package combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import entity.Character;
import entity.Enemie;
import entity.Player;
import util.AffichageManager;

public class Combat {
    private List<Player> playerList;
    private List<Enemie> enemieList;
    private List<Character> characterList;

    private boolean battleStop = false;


    private int turnNumber = 1;

    public void begin(){
        while (!battleStop){
            turn();
        }
    }

    public void turn(){

        AffichageManager.turnStart(turnNumber);

        characterList.sort(Comparator.comparingInt(a -> a.getStat().getAgility() + a.getTempStat().getAgility()));
        //change so that any character get chose next move
        characterList = characterList.reversed();

        for(Character character : characterList){
            AffichageManager.characterInformation(character);
        }

        ((Player) characterList.stream().filter(character -> character instanceof Player).findFirst().get()).choseNextMove();
        for(Character character : characterList){
            if(character.getCurrentHP()>0){
                character.nextMove(characterList);
            }
        }

        turnNumber++;

        endTurn();
    }

    public void endTurn(){
        for (Character character : characterList){
            character.getStatusList().turnEnd(character);
        }
        characterList.removeIf(character -> character.getCurrentHP() <= 0);
        long enemieCount = enemieList.stream().filter(enemie -> enemie.getCurrentHP() > 0).count();
        long playerCount = playerList.stream().filter(player -> player.getCurrentHP() > 0).count();
        if(playerCount ==0){
            battleStop = true;
            //battle lost
        }
        if (enemieCount==0){
            battleStop=true;
            //battle win
        }
    }

    public void battleLost(){

    }

    public void battleWon(){
//        int expGain = enemieList.stream().mapToInt(Enemie::getExpGain).sum();
//        for (Player player : playerList){
//            player.
//        }
    }

    public Combat(List<Player> playerList, List<Enemie> enemieList) {
        this.playerList=playerList;
        this.enemieList=enemieList;
        this.characterList = new ArrayList<>();
        characterList.addAll(playerList);
        characterList.addAll(enemieList);
    }

    public List<Character> getCharacterList() {
        return characterList;
    }
}
