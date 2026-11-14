package level;

import action.spells.StopSpell;
import entity.Stat;
import util.JsonManager;
import util.exception.LevelDontExisteException;

import java.util.ArrayList;
import java.util.List;

public class LevelList {
    private List<Level> levelList;
    private int levelMax;

    public LevelList(List<Level> levelList) {
        this.levelList = levelList;
        this.levelMax = levelList.size()+1;
    }


    public List<Level> getLevelList() {
        return levelList;
    }

    //for testing
    public LevelList(){

//        List<Level> levels = new ArrayList<>();
//        levels.add(new Level(new Stat(10,10,10, 10, 10, 0, 0),
//                null,
//                2,
//                10));
//        levels.add(new Level(new Stat(0,0,0,1,1,1, 1),
//                new StopSpell(),
//                3,
//                20));
//        this.levelList=levels;
//
//        this.levelMax = levelList.size()+1;
//
//        JsonManager<LevelList> json = new JsonManager<>(LevelList.class);
//        json.append("PlayerLevels.json", this);
    }

    public boolean levelExist(int nbLevel){
        return nbLevel<=levelMax;
    }

    public Level giveNbLevel(int nblevel){
        return levelList.stream().filter(level -> level.getLevelNb()==nblevel).findFirst().orElseThrow(()-> new LevelDontExisteException("Level "+nblevel+"doesn't exist"));
    }
}
