package action.actions;

import action.ActionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import status.Status;
import testingclasses.TesterEnemie;
import testingclasses.TesterPlayer;

import java.util.List;

public class DefendTest {

    Defend defend = new Defend();
    TesterEnemie testerEnemie;
    TesterPlayer testerPlayer;

    @BeforeEach
    void setUp(){
        testerEnemie=new TesterEnemie();
        testerPlayer=new TesterPlayer();
    }

    @Test
    void usualActivation(){
        ActionResult actionResult = defend.actionActivation(testerPlayer, List.of(testerEnemie));

        Assertions.assertEquals(ActionResult.BOOST, actionResult);
        Assertions.assertTrue(testerPlayer.getStatusList().containtStatus(Status.DEFEND));
        Assertions.assertEquals(10,testerPlayer.getTempStat().getDefence());
        Assertions.assertEquals(1,testerPlayer.getStatusList().getStatusDurationOfStatus(Status.DEFEND).getDurationLeft());

    }

    @Test
    void usualRemoving(){
        ActionResult actionResult = defend.actionActivation(testerPlayer, List.of(testerEnemie));

        testerPlayer.getStatusList().turnEnd(testerPlayer);

        Assertions.assertFalse(testerPlayer.getStatusList().containtStatus(Status.DEFEND));
        Assertions.assertEquals(0,testerPlayer.getTempStat().getDefence());
    }

    @Test
    void removingWithTempDefence(){
        testerPlayer.getTempStat().setDefence(100);

        ActionResult actionResult = defend.actionActivation(testerPlayer, List.of(testerEnemie));
        testerPlayer.getStatusList().turnEnd(testerPlayer);

        Assertions.assertEquals(100, testerPlayer.getTempStat().getDefence());

    }

}
