package util;

import java.util.Random;

public final class RandomManager {
    private final Random random;
    private static final RandomManager INSTANCE = new RandomManager();

    private RandomManager(){
        this.random=new Random();
    }

    private RandomManager(long seed){
        this.random=new Random(seed);
    }

//    public static RandomManager getInstance(long seed) {
//        if(INSTANCE == null){
//            return new RandomManager(seed);
//        }
//        return INSTANCE;
//    }

    public static RandomManager getInstance() {
        if(INSTANCE == null){
            return new  RandomManager();
        }
        return INSTANCE;
    }

    public Random getRandom() {
        return random;
    }

    public int getRandomIntBetween(int min, int max){
        return random.nextInt(max-min) + min;
    }

    public float getRandomFloatBetween(float min, float max){
        return random.nextFloat(max-min) + min;
    }

}
