package action.actions;

import action.ActionResult;
import entity.Stat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testingclasses.TesterEnemie;
import testingclasses.TesterPlayer;

import java.util.List;

public class PhysicalAttackTest {

    PhysicalAttack physicalAttack = new PhysicalAttack();

    TesterEnemie testerEnemie = new TesterEnemie();
    TesterPlayer testerPlayer = new TesterPlayer();

    @BeforeEach
    void setUp(){
        testerEnemie=new TesterEnemie();
        testerPlayer=new TesterPlayer();
    }

    @Test
    void damageRange(){

        ActionResult actionResult = physicalAttack.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.PHYSICALDAMAGE, actionResult);

        Assertions.assertTrue(testerEnemie.getCurrentHP()>=97 && testerEnemie.getCurrentHP() <=99);
    }

    @Test
    void noDamage(){
        testerEnemie.setStat(new Stat(100,100,10,20,0,0,0));

        ActionResult actionResult = physicalAttack.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.PHYSICALDAMAGE, actionResult);
        Assertions.assertEquals(100, testerEnemie.getCurrentHP());
    }

    @Test
    void attackEvaded(){
        testerPlayer.getStat().setStrength(10000);
        testerEnemie.getStat().setEvasionRate(101);

        ActionResult actionResult = physicalAttack.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.EVADED, actionResult);
        Assertions.assertEquals(100, testerEnemie.getCurrentHP());
    }
}
