package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.LivingObject;
import ru.javarush.november.timberg.island.living_objects.Plants;
import ru.javarush.november.timberg.island.living_objects.animals.AbstractAnimal;

import java.util.ArrayList;

import static java.lang.System.out;
import static ru.javarush.november.timberg.island.field.Config.MINIMUM_WEIGHT_INDEX;

public class WeightChecker extends Cell implements Runnable{
    private final Cell cell;

    public WeightChecker(Cell cell){
        this.cell = cell;
    }

    public synchronized void weightChecker() {
        ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
        for (LivingObject animal : cellList) {
            if(animal.getClass().equals(Plants.class)) continue;
            if (animal.getCurrentWeight() <= (animal.getMaxWeight() * MINIMUM_WEIGHT_INDEX)) {
                //out.println(animal + " убит!");
                this.cell.remove(animal);
            } else ((AbstractAnimal) animal).setSatiety(0);
        }
    }

    @Override
    public void run() {
        weightChecker();
    }
}
