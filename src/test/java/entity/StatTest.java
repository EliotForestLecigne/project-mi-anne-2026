package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.exception.InvalidInputException;

import static org.junit.jupiter.api.Assertions.*;

class StatTest {

    Stat stat;
    @BeforeEach
    void setUp() {
        stat=new Stat();
    }

    @Test
    void init(){
        assertEquals(0,stat.getMaxHP());
        assertEquals(0, stat.getMaxMP());
        assertEquals(0,stat.getStrength());
        assertEquals(0,stat.getDefence());
        assertEquals(0,stat.getAgility());
        assertEquals(0,stat.getEvasionRate());
        assertEquals(0,stat.getLuck());
    }

    @Test
    void addStat() {
        Stat statAdd = new Stat(1,2,3,4,5,6,7);
        stat.addStat(statAdd);

        assertEquals(1,stat.getMaxHP());
        assertEquals(2, stat.getMaxMP());
        assertEquals(3,stat.getStrength());
        assertEquals(4,stat.getDefence());
        assertEquals(5,stat.getAgility());
        assertEquals(6,stat.getEvasionRate());
        assertEquals(7,stat.getLuck());
    }

    @Test
    void addStatManual() {
        stat.addStat(1,2,3,4,5,6,7);

        assertEquals(1,stat.getMaxHP());
        assertEquals(2, stat.getMaxMP());
        assertEquals(3,stat.getStrength());
        assertEquals(4,stat.getDefence());
        assertEquals(5,stat.getAgility());
        assertEquals(6,stat.getEvasionRate());
        assertEquals(7,stat.getLuck());
    }

    @Test
    void setUpManual(){
        stat = new Stat(1,2,3,4,5,6,7);

        assertEquals(1,stat.getMaxHP());
        assertEquals(2, stat.getMaxMP());
        assertEquals(3,stat.getStrength());
        assertEquals(4,stat.getDefence());
        assertEquals(5,stat.getAgility());
        assertEquals(6,stat.getEvasionRate());
        assertEquals(7,stat.getLuck());
    }

    @Test
    void setUpException(){
        assertThrows(InvalidInputException.class,() -> new Stat(-1,0,0,0,0,0,0));
        assertThrows(InvalidInputException.class,() -> new Stat(0,-1,0,0,0,0,0));
        assertThrows(InvalidInputException.class,() -> new Stat(0,0,-1,0,0,0,0));
        assertThrows(InvalidInputException.class,() -> new Stat(0,0,0,-1,0,0,0));
        assertThrows(InvalidInputException.class,() -> new Stat(0,0,0,0,-1,0,0));
        assertThrows(InvalidInputException.class,() -> new Stat(0,0,0,0,0,-1,0));
        assertThrows(InvalidInputException.class,() -> new Stat(0,0,0,0,0,0,-1));


    }
}