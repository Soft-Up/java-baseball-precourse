package domain;


import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

//    @Override
//    public Integer generate(){
//        Random random = new Random();
//        random.setSeed(System.currentTimeMillis());
//        return random.nextInt(9);
//    }

    @Override
    public Integer generate() {
        double randomValue = Math.random();
        return (int)(randomValue*10);
    }
}
