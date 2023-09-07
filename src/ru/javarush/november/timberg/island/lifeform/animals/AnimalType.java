package ru.javarush.november.timberg.island.lifeform.animals;

import ru.javarush.november.timberg.island.lifeform.animals.herbivores.*;
import ru.javarush.november.timberg.island.lifeform.animals.predators.*;

import java.util.Arrays;

public enum AnimalType {
    WOLF(Wolf.class), EAGLE(Eagle.class), BOA(Boa.class), BEAR(Bear.class), FOX(Fox.class),
    BUFFALO(Buffalo.class), DEER(Deer.class), DUCK(Duck.class), GOAT(Goat.class), HORSE(Horse.class),
    MOUSE(Mouse.class), SHEEP(Sheep.class), BOAR(Boar.class), RABBIT(Rabbit.class), CATERPILLAR(Caterpillar.class);

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

