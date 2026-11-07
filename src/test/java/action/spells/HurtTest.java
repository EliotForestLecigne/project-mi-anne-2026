package action.spells;

import action.ActionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import status.Status;
import testingclasses.TesterEnemie;
import testingclasses.TesterPlayer;

import java.util.List;

public class HurtTest {

    Hurt hurt = new Hurt();

    TesterEnemie testerEnemie = new TesterEnemie();
    TesterPlayer testerPlayer = new TesterPlayer();

    @BeforeEach
    void setUp(){
        testerEnemie=new TesterEnemie();
        testerPlayer=new TesterPlayer();
    }

    @Test
    void usualCase(){

        ActionResult actionResult = hurt.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.MAGICDAMAGE, actionResult);
        Assertions.assertEquals(95,testerPlayer.getCurrentMP());
        Assertions.assertTrue(testerEnemie.getCurrentHP() >= 100-27 && testerEnemie.getCurrentHP() <= 100-20);
    }

    @Test
    void overDamage(){
        testerEnemie.setCurrentHP(1);
        ActionResult actionResult = hurt.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.MAGICDAMAGE, actionResult);
        Assertions.assertEquals(95,testerPlayer.getCurrentMP());
        Assertions.assertEquals(0, testerEnemie.getCurrentHP());
    }

    @Test
    void notEnoughMP(){
        testerPlayer.setCurrentMP(2);

        ActionResult actionResult = hurt.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.NOTENOUGHMP, actionResult);
        Assertions.assertEquals(2, testerPlayer.getCurrentMP());
        Assertions.assertEquals(100, testerEnemie.getCurrentHP());
    }

    @Test
    void stopSpell(){
        testerEnemie.setCurrentHP(1);
        testerPlayer.getStatusList().addStatusDuration(Status.STOPSPELL, 1, testerPlayer);

        ActionResult actionResult = hurt.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.CANTUSE, actionResult);
        Assertions.assertEquals(100, testerPlayer.getCurrentMP());
        Assertions.assertEquals(1, testerEnemie.getCurrentHP());
    }
}
