package ru.javarush.november.timberg.island.lifeform.animals.behavior;

import ru.javarush.november.timberg.island.lifeform.Organism;

import java.util.List;

public interface CanEat {
    List<Organism> eat(List<Organism> organisms, CanEat targetAnimal);
    double getMaxSatiety();

    double getCurrentSatiety();

    void setCurrentSatiety(Double satiety);
}

