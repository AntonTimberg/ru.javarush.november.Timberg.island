package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animal;
import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Plants;
import ru.javarush.november.timberg.island.animals.herbivores.*;
import ru.javarush.november.timberg.island.animals.predators.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static ru.javarush.november.timberg.island.field.Config.PLANTS_MAX_POPULATION;
import static ru.javarush.november.timberg.island.field.Config.POPULATION_RATE;

public class Cell implements Runnable {
    public ArrayList<Object> cell = new ArrayList<>();
    public static final Animals[] ANIMALS_ENUM = Animals.values();
    Random random = new Random();

    public void createCell() {
        for (int i = 0; i < ANIMALS_ENUM.length - 1; i++) {
            Animal x = (Animal) cellFill(ANIMALS_ENUM[i]);
            int maxCount = (int) (((int) x.getMaxPopulation()) * POPULATION_RATE);
            int random = (int) (Math.random() * ++maxCount);
            for (int j = 0; j < random; j++) {
                this.cell.add(cellFill(ANIMALS_ENUM[i]));
            }
        }

        int maxCount = (int) (Math.random() * (int) ((PLANTS_MAX_POPULATION + 1) * POPULATION_RATE));
        for (int i = 0; i < maxCount; i++) {
            this.cell.add(cellFill(ANIMALS_ENUM[ANIMALS_ENUM.length - 1]));
        }
    }

    public void removeAnimal(Object animal) {
        this.cell.remove(animal);
    }

    public ArrayList<Object> getCell() {
        return cell;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cell=" + cell +
                '}';
    }

    @Override
    public void run() {
        createCell();
    }

    public void hunting(Cell cell) {
        ArrayList<Object> cellList = new ArrayList<>(cell.getCell());

        for (Object object : cellList) {
            CellObject animal = (CellObject) object;
            double currentSatiety = 0;

            if (animal.getClass().equals(Plants.class)) continue;
            Map<Animals, Integer> eatMap = animal.getEatingProbability();

            for (Animals animals : eatMap.keySet()) {
                Class sacrClass = cellFill(animals).getClass();
                if (animal.getSatiety() <= currentSatiety) break;

                currentSatiety = currentSatiety + killFirst(cellList, sacrClass, eatMap, animals);

            }

            if (animal.getSatiety() > currentSatiety)
                animal.setCurrentWeight((animal.getCurrentWeight() * 0.9)); //если не наелся, отнимаем 10% текущего веса
            else if (animal.getCurrentWeight() < animal.getMaxWeight())
                animal.setCurrentWeight((animal.getCurrentWeight() + (animal.getCurrentWeight()) * 0.1)); //если наелся, прибавляем 10% текущего веса
        }
    }

    <T> double killFirst(ArrayList<Object> cellList, Class<T> type, Map<Animals, Integer> eatMap, Animals animal) {
        double satiety = 0;
        for (Object o : cellList) {
            if (o.getClass().equals(type)) {
                int random = this.random.nextInt(100);
                if (random <= eatMap.get(animal)) {
                    satiety = ((CellObject) o).getCurrentWeight();
                    this.cell.remove(o);
                    //System.out.print(cellFill(animal).toString() + " умерщвлён  ");
                }
            }
        }
        return satiety;
    }

    public void weightChecker(Cell cell) {
        System.out.println();
        ArrayList<Object> cellList = new ArrayList<>(cell.getCell());
        for (Object object : cellList) {
            CellObject animal = (CellObject) object;
            if (animal.getCurrentWeight() <= (animal.getMaxWeight() * 0.5)) {
                this.cell.remove(object);
                System.out.print(object.toString() + " умер от потери веса ");
            }
        }
    }

    public void reproduction(Cell cell) {
        System.out.println();
        ArrayList<Object> cellList = new ArrayList<>(cell.getCell());
        ArrayList<Class> classArray = new ArrayList<>();
        for (Object o : cellList) { // перебор пушистых
            Class oClass = o.getClass();
            if (oClass.equals(Plants.class)) continue;
            classArray.add(oClass);
        }

        for (Object o : cellList) {
            int count = 0;
            CellObject animal = (CellObject) o;
            Class oClass = o.getClass();
            if (oClass.equals(Plants.class)) continue;
            count = (int) classArray.stream().filter(oClass::equals).count();
            //System.out.println(count);
            if ((count < animal.getMaxPopulation()) && (count >= 2) && (animal.getCurrentWeight() > (animal.getMaxWeight() * 0.8))) {
                innerReproduction(oClass);
            }
        }
    }

    void innerReproduction(Class oClass) {
        for (Animals animals : ANIMALS_ENUM) {
            Object currentObject = cellFill(animals);
            if (oClass.equals(currentObject.getClass())) {
                this.cell.add(currentObject);
                System.out.print("родился " + currentObject + " ");
            }
        }
    }

    public void grassGrowth(Cell cell) {
        ArrayList<Object> cellList = new ArrayList<>(cell.getCell());
        Plants plants = new Plants();
        int count = 0;

        for (Object o : cellList) {
            CellObject animal = (CellObject) o;
            Class oClass = o.getClass();
            if (oClass.equals(Plants.class)) count++;
        }

        if (count < plants.getMaxPopulation()) {
            for (int i = 0; i < (plants.getMaxPopulation() * POPULATION_RATE); i++) {
                this.cell.add(new Plants());
            }
        }
    }

    public Object cellFill(Animals animal) { //Object, что-бы не добавлять растения к Animal
        switch (animal) {
            case WOLF:
                return new Wolf();
            case BOA:
                return new Boa();
            case FOX:
                return new Fox();
            case BEAR:
                return new Bear();
            case EAGLE:
                return new Eagle();
            case HORSE:
                return new Horse();
            case DEER:
                return new Deer();
            case RABBIT:
                return new Rabbit();
            case MOUSE:
                return new Mouse();
            case GOAT:
                return new Goat();
            case SHEEP:
                return new Sheep();
            case BOAR:
                return new Boar();
            case BUFFALO:
                return new Buffalo();
            case DUCK:
                return new Duck();
            case CATERPILLAR:
                return new Caterpillar();
            case PLANTS:
                return new Plants();

            default:
                throw new IllegalStateException("Invalid animal: " + animal);
        }
    }
}
