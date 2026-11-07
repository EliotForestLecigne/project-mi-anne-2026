package action.spells;

import action.ActionResult;
import action.actions.PhysicalAttack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import status.Status;
import testingclasses.TesterEnemie;
import testingclasses.TesterPlayer;

import java.util.List;

public class HealTest {

    Heal heal = new Heal();

    TesterEnemie testerEnemie = new TesterEnemie();
    TesterPlayer testerPlayer = new TesterPlayer();

    @BeforeEach
    void setUp(){
        testerEnemie=new TesterEnemie();
        testerPlayer=new TesterPlayer();
    }

    @Test
    void usualCase(){
        testerPlayer.setCurrentHP(1);

        ActionResult actionResult = heal.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.HEAL, actionResult);
        Assertions.assertEquals(97,testerPlayer.getCurrentMP());
        Assertions.assertTrue(testerPlayer.getCurrentHP() >= 21 && testerPlayer.getCurrentHP() <= 28);
    }

    @Test
    void overHeal(){
        ActionResult actionResult = heal.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.HEAL, actionResult);
        Assertions.assertEquals(97,testerPlayer.getCurrentMP());
        Assertions.assertEquals(100, testerPlayer.getCurrentHP());
    }

    @Test
    void notEnoughMP(){
        testerPlayer.setCurrentMP(2);

        ActionResult actionResult = heal.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.NOTENOUGHMP, actionResult);
        Assertions.assertEquals(2, testerPlayer.getCurrentMP());
        Assertions.assertEquals(100, testerPlayer.getCurrentHP());
    }

    @Test
    void stopSpell(){
        testerPlayer.setCurrentHP(1);
        testerPlayer.getStatusList().addStatusDuration(Status.STOPSPELL, 1, testerPlayer);

        ActionResult actionResult = heal.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.CANTUSE, actionResult);
        Assertions.assertEquals(100, testerPlayer.getCurrentMP());
        Assertions.assertEquals(1, testerPlayer.getCurrentHP());
    }
}
