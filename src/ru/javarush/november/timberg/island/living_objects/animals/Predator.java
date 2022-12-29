package ru.javarush.november.timberg.island.living_objects.animals;

import ru.javarush.november.timberg.island.living_objects.animals.Animal;

public abstract class Predator extends Animal {
    @Override
    public void eat() {
        System.out.println("Съел животное!");
    }
}
