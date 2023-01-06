package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.LivingObject;
import ru.javarush.november.timberg.island.living_objects.Plants;
import ru.javarush.november.timberg.island.living_objects.animals.AbstractAnimal;
import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;

import java.util.ArrayList;
import java.util.Map;

import static ru.javarush.november.timberg.island.field.Randomizer.getProbability;
import static ru.javarush.november.timberg.island.field.Config.WEIGHT_CHANGE_INDEX;

public class Hunting implements Runnable {

    private final Cell cell;

    public Hunting(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        hunting();
    }

    public void hunting() {
        Cell cellObj = new Cell();
        //cell.getLock();
//        try {
            ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
            for (LivingObject animal : cellList) {
                double currentSatiety = 0;

                if (animal.getClass().equals(Plants.class)) continue;
                Map<AnimalType, Integer> eatMap = ((AbstractAnimal) animal).getEatingProbability();

                for (AnimalType animalType : eatMap.keySet()) {
                    Class victimClass = cellObj.cellFill(animalType).getClass();
                    if (((AbstractAnimal) animal).getCurrentSatiety() <= currentSatiety) break;

                    currentSatiety = currentSatiety + killObject(cellList, victimClass, eatMap, animalType, cell);

                }
                if (((AbstractAnimal) animal).getCurrentSatiety() > currentSatiety)
                    ((AbstractAnimal) animal).setCurrentWeight((animal.getCurrentWeight()
                            - animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
                else if (animal.getCurrentWeight() < animal.getMaxWeight())
                    ((AbstractAnimal) animal).setCurrentWeight((animal.getCurrentWeight()
                            + animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
            }
//        } finally {
//            cell.getLock().unlock();
//        }
    }

    <T> double killObject(ArrayList<LivingObject> cellList, Class<T> type,
                          Map<AnimalType, Integer> eatMap, AnimalType animal, Cell cell) {
        double satiety = 0;
        for (LivingObject currentAnimal : cellList) {
            if (currentAnimal.getClass().equals(type)) {
                if (getProbability(eatMap.get(animal))) {
                    satiety = (currentAnimal).getCurrentWeight();
                    cell.remove(currentAnimal);
                }
            }
        }
        return satiety;
    }
}
