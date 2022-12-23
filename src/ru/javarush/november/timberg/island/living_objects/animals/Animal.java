package ru.javarush.november.timberg.island.living_objects.animals;

import ru.javarush.november.timberg.island.living_objects.CellObject;

import static java.lang.System.out;

public abstract class Animal implements CellObject {

    public double weight;
    public double getCurrentWeight(){
        return weight;
    }
    public abstract void eat();

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
