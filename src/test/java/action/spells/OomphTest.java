package action.spells;

import action.ActionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import status.Status;
import testingclasses.TesterEnemie;
import testingclasses.TesterPlayer;

import java.util.List;

public class OomphTest {

    Oomph oomph = new Oomph();

    TesterEnemie testerEnemie = new TesterEnemie();
    TesterPlayer testerPlayer = new TesterPlayer();

    @BeforeEach
    void setUp(){
        testerEnemie=new TesterEnemie();
        testerPlayer=new TesterPlayer();
    }

    @Test
    void usualCase(){
        ActionResult actionResult = oomph.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.BOOST, actionResult);
        Assertions.assertEquals(90, testerPlayer.getCurrentMP());
        Assertions.assertTrue(testerPlayer.getStatusList().containtStatus(Status.OOMPH));
        Assertions.assertEquals(10, testerPlayer.getTempStat().getStrength());
        Assertions.assertEquals(4, testerPlayer.getStatusList().getStatusDurationOfStatus(Status.OOMPH).getDurationLeft());
    }

    @Test
    void usualRemove(){
        ActionResult actionResult = oomph.actionActivation(testerPlayer, List.of(testerEnemie));


        for (int i = 0; i < 4 ; i++) {
            testerPlayer.getStatusList().turnEnd(testerPlayer);
        }

        Assertions.assertFalse(testerPlayer.getStatusList().containtStatus(Status.OOMPH));
        Assertions.assertEquals(0, testerPlayer.getTempStat().getStrength());
    }

    @Test
    void withTempStrength(){
        testerPlayer.getTempStat().setStrength(100);
        ActionResult actionResult = oomph.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(110, testerPlayer.getTempStat().getStrength());

        for (int i = 0; i < 4 ; i++) {
            testerPlayer.getStatusList().turnEnd(testerPlayer);
        }

        Assertions.assertFalse(testerPlayer.getStatusList().containtStatus(Status.OOMPH));
        Assertions.assertEquals(100, testerPlayer.getTempStat().getStrength());
    }

    @Test
    void multiple(){
        ActionResult actionResult = oomph.actionActivation(testerPlayer, List.of(testerEnemie));
        oomph.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.BOOST, actionResult);
        Assertions.assertEquals(80, testerPlayer.getCurrentMP());
        Assertions.assertTrue(testerPlayer.getStatusList().containtStatus(Status.OOMPH));
        Assertions.assertEquals(10, testerPlayer.getTempStat().getStrength());
        Assertions.assertEquals(8, testerPlayer.getStatusList().getStatusDurationOfStatus(Status.OOMPH).getDurationLeft());
    }


    @Test
    void notEnoughMP(){
        testerPlayer.setCurrentMP(2);

        ActionResult actionResult = oomph.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.NOTENOUGHMP, actionResult);
        Assertions.assertEquals(2, testerPlayer.getCurrentMP());
        Assertions.assertFalse(testerPlayer.getStatusList().containtStatus(Status.OOMPH));
    }

    @Test
    void stopSpell(){
        testerPlayer.getStatusList().addStatusDuration(Status.STOPSPELL, 1, testerPlayer);

        ActionResult actionResult = oomph.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.CANTUSE, actionResult);
        Assertions.assertFalse(testerPlayer.getStatusList().containtStatus(Status.OOMPH));
        Assertions.assertEquals(100, testerPlayer.getCurrentMP());
    }
}
