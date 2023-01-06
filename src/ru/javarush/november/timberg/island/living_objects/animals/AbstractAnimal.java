package ru.javarush.november.timberg.island.living_objects.animals;

import ru.javarush.november.timberg.island.living_objects.LivingObject;

import java.util.Map;

import static java.lang.System.out;

public abstract class AbstractAnimal implements LivingObject {
    protected double weight;
    protected double satiety;


    public double getCurrentWeight() {
        return weight;
    }

    public void setCurrentWeight(double weight) {
        this.weight = weight;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public double getCurrentSatiety() {
        return satiety;
    }

    public abstract double getMaxSatiety();

    public abstract Map<AnimalType, Integer> getEatingProbability();

    public void move() {
        out.println("Переместился в...");
    }

    public void reproduction() {
        out.println("Дал потомство...");
    }

    public void dieFromHunger() {
        out.println("Умер от голода...");
    }

    public void beEaten() {
        out.println("Был съеден...");
    }
}
