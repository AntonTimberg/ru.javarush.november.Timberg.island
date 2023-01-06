package ru.javarush.november.timberg.island.living_objects;

import ru.javarush.november.timberg.island.field.Config;

import static ru.javarush.november.timberg.island.field.Config.PLANTS_WEIGHT;

public class Plants implements LivingObject {

    @Override
    public double getMaxWeight() {
        return PLANTS_WEIGHT;
    }

    @Override
    public double getMaxPopulation() {
        return Config.PLANTS_MAX_POPULATION;
    }

    @Override
    public double getMaxSpeed() {
        return Config.PLANTS_MAX_SPEED;
    }

    @Override
    public String getUnicode() {
        return Config.PLANTS_UNICODE;
    }

    @Override
    public String toString() {
        return "Plants " + getUnicode();
    }

    public double getCurrentWeight(){
        return PLANTS_WEIGHT;
    }
}
