package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animals;

import java.util.Map;

import static ru.javarush.november.timberg.island.animals.Animals.*;

public class Config {
    public static final int ISLE_LENGTH = 1;
    public static final int ISLE_WIDTH = 1;
    public static final int TRY_HUNTING_COUNT = 5;

    public static final double POPULATION_RATE = 0.05; // 1 - при обычных (100%) значениях популяции животных и растений
    public static final double MINIMUM_WEIGHT_INDEX = 0.55; // если индекс ниже, то смерть объекта

    public static final double BOAR_WEIGHT = 400;
    public static final double BOAR_MAX_POPULATION = 50;
    public static final double BOAR_MAX_SPEED = 2;
    public static final double BOAR_SATIETY = 50;
    public static final String BOAR_UNICODE = "\uD83D\uDC17";

    public static final Map<Animals, Integer> BOAR_EATING_MAP = Map.ofEntries(
            Map.entry(MOUSE, 50),
            Map.entry(CATERPILLAR, 90),
            Map.entry(PLANTS, 100)
    );

    public static final double BUFFALO_WEIGHT = 700;
    public static final double BUFFALO_MAX_POPULATION = 10;
    public static final double BUFFALO_MAX_SPEED = 3;
    public static final double BUFFALO_SATIETY = 100;
    public static final String BUFFALO_UNICODE = "\uD83D\uDC03";

    public static final Map<Animals, Integer> BUFFALO_EATING_MAP = Map.ofEntries(
            Map.entry(Animals.PLANTS, 100)
    );

    public static final double CATERPILLAR_WEIGHT = 0.01;
    public static final double CATERPILLAR_MAX_POPULATION = 1000;
    public static final double CATERPILLAR_MAX_SPEED = 0;
    public static final double CATERPILLAR_SATIETY = 0;
    public static final String CATERPILLAR_UNICODE = "\uD83D\uDC1B";

    public static final Map<Animals, Integer> CATERPILLAR_EATING_MAP = Map.ofEntries(
            Map.entry(Animals.PLANTS, 100)
    );

    public static final double DEER_WEIGHT = 300;
    public static final double DEER_MAX_POPULATION = 20;
    public static final double DEER_MAX_SPEED = 4;
    public static final double DEER_SATIETY = 50;
    public static final String DEER_UNICODE = "\uD83E\uDD8C";

    public static final Map<Animals, Integer> DEER_EATING_MAP = Map.ofEntries(
            Map.entry(PLANTS, 100)
    );

    public static final double DUCK_WEIGHT = 1;
    public static final double DUCK_MAX_POPULATION = 200;
    public static final double DUCK_MAX_SPEED = 4;
    public static final double DUCK_SATIETY = 0.15;
    public static final String DUCK_UNICODE = "\uD83E\uDD86";

    public static final Map<Animals, Integer> DUCK_EATING_MAP = Map.ofEntries(
            Map.entry(Animals.CATERPILLAR, 90),
            Map.entry(Animals.PLANTS, 100)
    );

    public static final double GOAT_WEIGHT = 60;
    public static final double GOAT_MAX_POPULATION = 140;
    public static final double GOAT_MAX_SPEED = 3;
    public static final double GOAT_SATIETY = 10;
    public static final String GOAT_UNICODE = "\uD83D\uDC10";

    public static final Map<Animals, Integer> GOAT_EATING_MAP = Map.ofEntries(
            Map.entry(PLANTS, 100)
    );

    public static final double HORSE_WEIGHT = 400;
    public static final double HORSE_MAX_POPULATION = 20;
    public static final double HORSE_MAX_SPEED = 4;
    public static final double HORSE_SATIETY = 50;
    public static final String HORSE_UNICODE = "\uD83D\uDC0E";

    public static final Map<Animals, Integer> HORSE_EATING_MAP = Map.ofEntries(
            Map.entry(PLANTS, 100)
    );

    public static final double MOUSE_WEIGHT = 0.05;
    public static final double MOUSE_MAX_POPULATION = 500;
    public static final double MOUSE_MAX_SPEED = 1;
    public static final double MOUSE_SATIETY = 0.01;
    public static final String MOUSE_UNICODE = "\uD83D\uDC01";

    public static final Map<Animals, Integer> MOUSE_EATING_MAP = Map.ofEntries(
            Map.entry(CATERPILLAR, 90),
            Map.entry(PLANTS, 100)
    );

    public static final double RABBIT_WEIGHT = 2;
    public static final double RABBIT_MAX_POPULATION = 150;
    public static final double RABBIT_MAX_SPEED = 2;
    public static final double RABBIT_SATIETY = 0.45;
    public static final String RABBIT_UNICODE = "\uD83D\uDC07";

    public static final Map<Animals, Integer> RABBIT_EATING_MAP = Map.ofEntries(
            Map.entry(PLANTS, 100)
    );

    public static final double SHEEP_WEIGHT = 70;
    public static final double SHEEP_MAX_POPULATION = 140;
    public static final double SHEEP_MAX_SPEED = 3;
    public static final double SHEEP_SATIETY = 15;
    public static final String SHEEP_UNICODE = "\uD83D\uDC11";

    public static final Map<Animals, Integer> SHEEP_EATING_MAP = Map.ofEntries(
            Map.entry(PLANTS, 100)
    );

    public static final double BEAR_WEIGHT = 500;
    public static final double BEAR_MAX_POPULATION = 5;
    public static final double BEAR_MAX_SPEED = 2;
    public static final double BEAR_SATIETY = 80;
    public static final String BEAR_UNICODE = "\uD83D\uDC3B";

    public static final Map<Animals, Integer> BEAR_EATING_MAP = Map.ofEntries(
            Map.entry(Animals.BOA, 80),
            Map.entry(Animals.HORSE, 40),
            Map.entry(Animals.DEER, 80),
            Map.entry(Animals.RABBIT, 80),
            Map.entry(Animals.MOUSE, 90),
            Map.entry(Animals.GOAT, 70),
            Map.entry(Animals.SHEEP, 70),
            Map.entry(Animals.BOAR, 50),
            Map.entry(Animals.BUFFALO, 20),
            Map.entry(Animals.DUCK, 10)
    );

    public static final double BOA_WEIGHT = 15;
    public static final double BOA_MAX_POPULATION = 30;
    public static final double BOA_MAX_SPEED = 1;
    public static final double BOA_SATIETY = 3;
    public static final String BOA_UNICODE = "\uD83D\uDC0D";

    public static final Map<Animals, Integer> BOA_EATING_MAP = Map.ofEntries(
            Map.entry(Animals.FOX, 15),
            Map.entry(Animals.RABBIT, 20),
            Map.entry(Animals.MOUSE, 40),
            Map.entry(Animals.DUCK, 10)
    );

    public static final double EAGLE_WEIGHT = 6;
    public static final double EAGLE_MAX_POPULATION = 20;
    public static final double EAGLE_MAX_SPEED = 3;
    public static final double EAGLE_SATIETY = 1;
    public static final String EAGLE_UNICODE = "\uD83E\uDD85";

    public static final Map<Animals, Integer> EAGLE_EATING_MAP = Map.ofEntries(
            Map.entry(FOX, 10),
            Map.entry(RABBIT, 90),
            Map.entry(MOUSE, 90),
            Map.entry(DUCK, 80)
    );

    public static final double FOX_WEIGHT = 8;
    public static final double FOX_MAX_POPULATION = 30;
    public static final double FOX_MAX_SPEED = 2;
    public static final double FOX_SATIETY = 2;
    public static final String FOX_UNICODE = "\uD83E\uDD8A";

    public static final Map<Animals, Integer> FOX_EATING_MAP = Map.ofEntries(
            Map.entry(RABBIT, 70),
            Map.entry(MOUSE, 90),
            Map.entry(DUCK, 60),
            Map.entry(CATERPILLAR, 40)
    );

    public static final double WOLF_WEIGHT = 50;
    public static final double WOLF_MAX_POPULATION = 30;
    public static final double WOLF_MAX_SPEED = 3;
    public static final double WOLF_SATIETY = 8;
    public static final String WOLF_UNICODE = "\uD83D\uDC3A";

    public static final Map<Animals, Integer> WOLF_EATING_MAP = Map.ofEntries(
            Map.entry(Animals.HORSE, 10),
            Map.entry(Animals.DEER, 15),
            Map.entry(Animals.RABBIT, 60),
            Map.entry(Animals.MOUSE, 80),
            Map.entry(Animals.GOAT, 60),
            Map.entry(Animals.SHEEP, 70),
            Map.entry(Animals.BOAR, 15),
            Map.entry(Animals.BUFFALO, 10),
            Map.entry(Animals.DUCK, 40)
    );

    public static final double PLANTS_WEIGHT = 1;
    public static final int PLANTS_MAX_POPULATION = 200;
    public static final double PLANTS_MAX_SPEED = 0;
    public static final double PLANTS_SATIETY = 0;
    public static final String PLANTS_UNICODE = "\uD83C\uDF3E";
}
