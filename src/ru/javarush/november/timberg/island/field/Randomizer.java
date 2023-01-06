package ru.javarush.november.timberg.island.field;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static boolean getProbability(int percent) {return getRandom(0, 100) < percent;}

    public static int getRandom(int from, int to) { return ThreadLocalRandom.current().nextInt(from, to + 1); }

    public static double getRandom(double from, double to) {
        return  ThreadLocalRandom.current().nextDouble(from, to + 1D);
    }
}
