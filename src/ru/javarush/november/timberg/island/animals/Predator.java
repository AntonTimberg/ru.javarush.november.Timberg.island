package ru.javarush.november.timberg.island.animals;

public abstract class Predator extends Animal {
    @Override
    public void eat() {
        System.out.println("Съел животное!");
    }
}
