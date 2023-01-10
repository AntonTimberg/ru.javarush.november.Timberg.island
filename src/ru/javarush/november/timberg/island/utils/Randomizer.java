package ru.javarush.november.timberg.island.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static int getRandom(int from, int to) { return ThreadLocalRandom.current().nextInt(from, to+1); }
}
