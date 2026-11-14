package level;

import action.ActionEnum;
import entity.Stat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.exception.LevelDontExisteException;

import java.awt.*;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class LevelListTest {
    LevelList levelList;

    @BeforeEach
    void setUp(){
        List<Level> levels = List.of(new Level(new Stat(1,1,1,1,1,1,1),
                ActionEnum.HEAL.getAction(),
                2,
                100),
                new Level(new Stat(0,0,1,1,1,1,1),
                        null,
                        3,
                        200)
                );
        levelList = new LevelList(levels);
    }

    @Test
    void checkSetup(){
        assertEquals(3, levelList.getLevelMax());
    }

    @Test
    void levelExist(){
        assertTrue(levelList.levelExist(2));
        assertTrue(levelList.levelExist(3));
        assertFalse(levelList.levelExist(4));
    }

    @Test
    void getLevel(){
        Level level = levelList.giveNbLevel(2);
        assertEquals(ActionEnum.HEAL.getAction(),level.getAction());
        assertEquals(100, level.getExpThreshold());
    }

    @Test
    void getLevelDontExisteException(){
        assertThrows(LevelDontExisteException.class, ()-> levelList.giveNbLevel(4));
        assertThrows(LevelDontExisteException.class, ()-> levelList.giveNbLevel(0));
    }

}