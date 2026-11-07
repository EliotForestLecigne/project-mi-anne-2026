package action.spells;

import action.ActionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import status.Status;
import testingclasses.TesterEnemie;
import testingclasses.TesterPlayer;

import java.util.List;

public class StopSpellTest {

    StopSpell stopSpell = new StopSpell();

    TesterEnemie testerEnemie1 = new TesterEnemie();
    TesterEnemie testerEnemie2 = new TesterEnemie();
    TesterPlayer testerPlayer = new TesterPlayer();

    @BeforeEach
    void setUp(){
        testerEnemie1=new TesterEnemie();
        testerEnemie2=new TesterEnemie();
        testerPlayer=new TesterPlayer();
    }

    @Test
    void usualCase(){
        ActionResult actionResult = stopSpell.actionActivation(testerPlayer, List.of(testerEnemie1, testerEnemie2));

        Assertions.assertEquals(ActionResult.STATUSAFFLICTED, actionResult);
        Assertions.assertEquals(90, testerPlayer.getCurrentMP());
        Assertions.assertTrue(testerEnemie1.getStatusList().containtStatus(Status.STOPSPELL));
        Assertions.assertTrue(testerEnemie2.getStatusList().containtStatus(Status.STOPSPELL));
        Assertions.assertEquals(3, testerEnemie1.getStatusList().getStatusDurationOfStatus(Status.STOPSPELL).getDurationLeft());
        Assertions.assertEquals(3, testerEnemie2.getStatusList().getStatusDurationOfStatus(Status.STOPSPELL).getDurationLeft());

    }

    @Test
    void usualRemove(){
        ActionResult actionResult = stopSpell.actionActivation(testerPlayer, List.of(testerEnemie1, testerEnemie2));

        for (int i = 0; i < 3; i++) {
            testerEnemie1.getStatusList().turnEnd(testerEnemie1);
            testerEnemie2.getStatusList().turnEnd(testerEnemie2);
        }

        Assertions.assertFalse(testerEnemie1.getStatusList().containtStatus(Status.STOPSPELL));
        Assertions.assertFalse(testerEnemie2.getStatusList().containtStatus(Status.STOPSPELL));
    }

    @Test
    void notEnoughMP(){
        testerPlayer.setCurrentMP(2);

        ActionResult actionResult = stopSpell.actionActivation(testerPlayer, List.of(testerEnemie1));

        Assertions.assertEquals(ActionResult.NOTENOUGHMP, actionResult);
        Assertions.assertEquals(2, testerPlayer.getCurrentMP());
        Assertions.assertFalse(testerEnemie1.getStatusList().containtStatus(Status.STOPSPELL));
    }

    @Test
    void stopSpell(){
        testerPlayer.getStatusList().addStatusDuration(Status.STOPSPELL, 1, testerPlayer);

        ActionResult actionResult = stopSpell.actionActivation(testerPlayer, List.of(testerEnemie1));

        Assertions.assertEquals(ActionResult.CANTUSE, actionResult);
        Assertions.assertFalse(testerEnemie1.getStatusList().containtStatus(Status.STOPSPELL));
        Assertions.assertEquals(100, testerPlayer.getCurrentMP());
    }
}
