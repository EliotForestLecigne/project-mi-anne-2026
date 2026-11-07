package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomManagerTest {


    @Test
    void testIntRandomRange(){
       int number = RandomManager.getInstance().getRandomIntBetween(0,100);
        Assertions.assertTrue(number>=0 && number<=100);
    }

    @Test
    void testFloatRandomRange(){
        float number = RandomManager.getInstance().getRandomFloatBetween(0,100);
        Assertions.assertTrue(number>=0 && number<=100);
    }
}
