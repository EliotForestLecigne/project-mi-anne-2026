package combat;

import entity.Enemie;
import entity.IEnemie;
import entity.enemies.Slime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Encounters {
SLIME("slime", new ArrayList<>(Arrays.asList( new Slime("Slime A"))));


    public String getName() {
        return name;
    }

    public List<IEnemie> getEnemies() {
        return enemies;
    }

    private String name;
    private List<IEnemie> enemies;

    private Encounters(String name, List<IEnemie> enemies){
        this.name = name;
        this.enemies=enemies;
    }
}
