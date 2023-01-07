package ru.javarush.november.timberg.island.board;

public class BoardSetting {
    public static final BoardSetting DEFAULT = new BoardSetting();

    private int width = 100;
    private int length = 20;

    public BoardSetting() {
    }

    public BoardSetting(int width, int length) {
       this.width = width;
       this.length = length;
    }

    public int getWidth() {
       return width;
    }

    public int getLength() {
       return length;
    }


    public static final double POPULATION_RATE = 1;

    // если индекс ниже, то смерть объекта
    public static final double MINIMUM_WEIGHT_INDEX = 0.55;
    public static final double WEIGHT_CHANGE_INDEX = 0.1;
    public static final double WEIGHT_INDEX_REPRODUCTION = 0.8;

    public static final double RABBIT_MAX_WEIGHT = 2;
    public static final Integer RABBIT_MAX_POPULATION = 150;
    public static final int RABBIT_MAX_SPEED = 2;
    public static final double RABBIT_SATIETY = 0.45;
    public static final String RABBIT_UNICODE = "\uD83D\uDC07";

    public static final double WOLF_MAX_WEIGHT = 50;
    public static final Integer WOLF_MAX_POPULATION = 30;
    public static final int WOLF_MAX_SPEED = 3;
    public static final double WOLF_MAX_SATIETY = 8;
    public static final String WOLF_UNICODE = "\uD83D\uDC3A";

    public static final double PLANTS_WEIGHT = 1;
    public static final Integer PLANTS_MAX_POPULATION = 200;
    public static final int PLANTS_MAX_SPEED = 0;
    public static final String PLANTS_UNICODE = "\uD83C\uDF3E";


    public static final double BOA_WEIGHT = 15;
    public static final Integer BOA_MAX_POPULATION = 30;
    public static final int BOA_MAX_SPEED = 1;
    public static final double BOA_SATIETY = 3;
    public static final String BOA_UNICODE = "\uD83D\uDC0D";

    public static final double BOAR_WEIGHT = 400;
    public static final Integer BOAR_MAX_POPULATION = 50;
    public static final int BOAR_MAX_SPEED = 2;
    public static final double BOAR_SATIETY = 50;
    public static final String BOAR_UNICODE = "\uD83D\uDC17";

    public static final double BUFFALO_WEIGHT = 700;
    public static final Integer BUFFALO_MAX_POPULATION = 10;
    public static final int BUFFALO_MAX_SPEED = 3;
    public static final double BUFFALO_SATIETY = 100;
    public static final String BUFFALO_UNICODE = "\uD83D\uDC03";

    public static final double CATERPILLAR_WEIGHT = 0.01;
    public static final Integer CATERPILLAR_MAX_POPULATION = 1000;
    public static final int CATERPILLAR_MAX_SPEED = 0;
    public static final double CATERPILLAR_SATIETY = 0;
    public static final String CATERPILLAR_UNICODE = "\uD83D\uDC1B";

    public static final double DEER_WEIGHT = 300;
    public static final Integer DEER_MAX_POPULATION = 20;
    public static final int DEER_MAX_SPEED = 4;
    public static final double DEER_SATIETY = 50;
    public static final String DEER_UNICODE = "\uD83E\uDD8C";

    public static final double DUCK_WEIGHT = 1;
    public static final Integer DUCK_MAX_POPULATION = 200;
    public static final int DUCK_MAX_SPEED = 4;
    public static final double DUCK_SATIETY = 0.15;
    public static final String DUCK_UNICODE = "\uD83E\uDD86";

    public static final double GOAT_WEIGHT = 60;
    public static final Integer GOAT_MAX_POPULATION = 140;
    public static final int GOAT_MAX_SPEED = 3;
    public static final double GOAT_SATIETY = 10;
    public static final String GOAT_UNICODE = "\uD83D\uDC10";

    public static final double HORSE_WEIGHT = 400;
    public static final Integer HORSE_MAX_POPULATION = 20;
    public static final int HORSE_MAX_SPEED = 4;
    public static final double HORSE_SATIETY = 50;
    public static final String HORSE_UNICODE = "\uD83D\uDC0E";

    public static final double MOUSE_WEIGHT = 0.05;
    public static final int MOUSE_MAX_POPULATION = 500;
    public static final Integer MOUSE_MAX_SPEED = 1;
    public static final double MOUSE_SATIETY = 0.01;
    public static final String MOUSE_UNICODE = "\uD83D\uDC01";

    public static final double SHEEP_WEIGHT = 70;
    public static final Integer SHEEP_MAX_POPULATION = 140;
    public static final int SHEEP_MAX_SPEED = 3;
    public static final double SHEEP_SATIETY = 15;
    public static final String SHEEP_UNICODE = "\uD83D\uDC11";

    public static final double BEAR_WEIGHT = 500;
    public static final Integer BEAR_MAX_POPULATION = 5;
    public static final int BEAR_MAX_SPEED = 2;
    public static final double BEAR_SATIETY = 80;
    public static final String BEAR_UNICODE = "\uD83D\uDC3B";

    public static final double EAGLE_WEIGHT = 6;
    public static final Integer EAGLE_MAX_POPULATION = 20;
    public static final int EAGLE_MAX_SPEED = 3;
    public static final double EAGLE_SATIETY = 1;
    public static final String EAGLE_UNICODE = "\uD83E\uDD85";

    public static final double FOX_WEIGHT = 8;
    public static final Integer FOX_MAX_POPULATION = 30;
    public static final int FOX_MAX_SPEED = 2;
    public static final double FOX_SATIETY = 2;
    public static final String FOX_UNICODE = "\uD83E\uDD8A";
}
