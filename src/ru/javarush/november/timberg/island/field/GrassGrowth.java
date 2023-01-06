package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.LivingObject;
import ru.javarush.november.timberg.island.living_objects.Plants;

import java.util.ArrayList;

import static ru.javarush.november.timberg.island.field.Config.POPULATION_RATE;

public class GrassGrowth implements Runnable{
    private final Cell cell;

    public GrassGrowth(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        grassGrowth();
    }

    public void grassGrowth() {
        Randomizer randomizer = new Randomizer();
        ArrayList<LivingObject> cellList = new ArrayList<>(this.cell.getCell());
        Plants plants = new Plants();
        int count = 0;

        for (LivingObject animal : cellList) {
            Class clazz = animal.getClass();
            if (clazz.equals(Plants.class)) count++;
        }

        if (count < plants.getMaxPopulation()) {
            for (int i = 0; i < randomizer.getRandom(0,plants.getMaxPopulation() * POPULATION_RATE); i++) {
                this.cell.getCell().add(new Plants());
            }
        }
    }
}
