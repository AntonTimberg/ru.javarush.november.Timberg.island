package ru.javarush.november.timberg.island.living_objects.animals;

import ru.javarush.november.timberg.island.living_objects.animals.Animal;

public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        System.out.println("Жуёт растения...");
    }
}
