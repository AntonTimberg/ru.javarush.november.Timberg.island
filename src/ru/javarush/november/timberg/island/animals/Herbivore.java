package ru.javarush.november.timberg.island.animals;

public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        System.out.println("Жуёт растения...");
    }
}
