package ru.javarush.november.timberg.island.lifeform.animals.behavior;
public interface CanEat {
    double getMaxSatiety();

    double getCurrentSatiety();

    void setCurrentSatiety(Double satiety);
}

