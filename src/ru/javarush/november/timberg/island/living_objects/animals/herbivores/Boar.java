package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;


public class Boar extends Herbivore {
    {
        weight = (double) Math.round((Math.random()
                * ((BOAR_WEIGHT - (BOAR_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (BOAR_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    @Override
    public double getMaxWeight() {
        return BOAR_WEIGHT;
    }

    @Override
    public double getMaxPopulation() {
        return BOAR_MAX_POPULATION;
    }

    @Override
    public double getMaxSpeed() {
        return BOAR_MAX_SPEED;
    }

    @Override
    public double getMaxSatiety() {
        return BOAR_SATIETY;
    }

    @Override
    public String getUnicode() {
        return BOAR_UNICODE;
    }

    @Override
    public String toString() {
        return "Boar " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return BOAR_EATING_MAP;
    }
}
