package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDigits {
    public static int generateRandomNumber() {
        int max = 7;
        int min = 2;
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }
}
