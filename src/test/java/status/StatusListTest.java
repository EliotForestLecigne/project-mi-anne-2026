package status;

import entity.ICharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testingclasses.TesterPlayer;

import static org.junit.jupiter.api.Assertions.*;

class StatusListTest {

    StatusList statusList = new StatusList();

    ICharacter iCharacter = new TesterPlayer();

     @BeforeEach
    void setUp(){
         statusList = new StatusList();
     }

     @Test
    void addStatus(){
         statusList.addStatusDuration(Status.OOMPH, 5, iCharacter);

         StatusDuration statusDuration = statusList.getStatusDurations().get(0);

         assertEquals(5,statusDuration.getDurationLeft());
         assertEquals(Status.OOMPH,statusDuration.getStatus());
     }

     @Test
    void extendStatus(){
         statusList.addStatusDuration(Status.OOMPH, 5, iCharacter);
         statusList.addStatusDuration(Status.OOMPH, 5, iCharacter);

         StatusDuration statusDuration = statusList.getStatusDurations().get(0);

         assertEquals(10,statusDuration.getDurationLeft());
         assertEquals(Status.OOMPH,statusDuration.getStatus());

         assertEquals(1, statusList.getStatusDurations().size());
     }

     @Test
    void statusExpiration(){
         statusList.addStatusDuration(Status.OOMPH, 2, iCharacter);
         statusList.turnEnd(iCharacter);
         statusList.turnEnd(iCharacter);

         assertEquals(0, statusList.getStatusDurations().size());
     }

     @Test
    void checkIfContaint(){
         assertFalse(statusList.containtStatus(Status.OOMPH));

         statusList.addStatusDuration(Status.OOMPH, 2, iCharacter);

         assertTrue(statusList.containtStatus(Status.OOMPH));
     }

     @Test
    void getStatusDuration(){
         statusList.addStatusDuration(Status.OOMPH, 2, iCharacter);
         StatusDuration statusDuration = statusList.getStatusDurationOfStatus(Status.OOMPH);

         assertEquals(Status.OOMPH, statusDuration.getStatus());
         assertEquals(2, statusDuration.getDurationLeft());
     }
}