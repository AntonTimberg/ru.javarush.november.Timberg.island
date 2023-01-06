package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;


public class Sheep extends Herbivore {
    {
        weight = (double) Math.round((Math.random()
                * ((SHEEP_WEIGHT - (SHEEP_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (SHEEP_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return SHEEP_WEIGHT;
    }

    public double getMaxPopulation() {
        return SHEEP_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return SHEEP_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return SHEEP_SATIETY;
    }

    public String getUnicode() {
        return SHEEP_UNICODE;
    }

    @Override
    public String toString() {
        return "Sheep " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return SHEEP_EATING_MAP;
    }
}
