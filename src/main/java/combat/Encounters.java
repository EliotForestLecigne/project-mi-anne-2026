package combat;

import entity.Enemie;
import entity.enemies.Slime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Encounters {
SLIME("slime", new ArrayList<>(Arrays.asList( new Slime("Slime A"))));


    public String getName() {
        return name;
    }

    public List<Enemie> getEnemies() {
        return enemies;
    }

    private String name;
    private List<Enemie> enemies;

    private Encounters(String name, List<Enemie> enemies){
        this.name = name;
        this.enemies=enemies;
    }
}
