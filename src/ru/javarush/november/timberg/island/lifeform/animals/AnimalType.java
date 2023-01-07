package ru.javarush.november.timberg.island.lifeform.animals;

import ru.javarush.november.timberg.island.lifeform.animals.herbivores.*;
import ru.javarush.november.timberg.island.lifeform.animals.predators.*;

import java.util.Arrays;

public enum AnimalType {
    WOLF(Wolf.class), RABBIT(Rabbit.class), BOA(Boa.class), BOAR(Boar.class), BUFFALO(Buffalo.class),
    CATERPILLAR(Caterpillar.class), DEER(Deer.class), DUCK(Duck.class), GOAT(Goat.class), HORSE(Horse.class),
    MOUSE(Mouse.class), SHEEP(Sheep.class), BEAR(Bear.class), EAGLE(Eagle.class), FOX(Fox.class);

    private final Class<? extends Animal> type;

    AnimalType(Class<? extends Animal> type) {
        this.type = type;
    }

    public static AnimalType typeOf(Animal animal) {
        return Arrays.stream(values())
                .filter(animalType -> animalType.type.isInstance(animal))
                .findAny().orElse(null);
    }
}

