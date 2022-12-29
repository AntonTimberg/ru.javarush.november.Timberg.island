package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.animals.Animal;
import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.CellObject;
import ru.javarush.november.timberg.island.living_objects.Plants;
import ru.javarush.november.timberg.island.living_objects.animals.herbivores.*;
import ru.javarush.november.timberg.island.living_objects.animals.predators.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ru.javarush.november.timberg.island.field.Config.*;
import static ru.javarush.november.timberg.island.field.Isle.MY_ISLE;

public class Cell implements Runnable {
    protected ArrayList<CellObject> cell = new ArrayList<>();
    protected static final Animals[] ANIMALS_ENUM = Animals.values();
    private final Lock lock = new ReentrantLock(true);
    Random randomNumber = new Random();

    public void createCell() {
        for (int i = 0; i < ANIMALS_ENUM.length - 1; i++) {
            Animal animal = (Animal) cellFill(ANIMALS_ENUM[i]);
            int maxCount = (int) (((int) animal.getMaxPopulation()) * POPULATION_RATE);
            int random = randomNumber.nextInt(maxCount);
            for (int j = 0; j < random; j++) {
                this.cell.add(cellFill(ANIMALS_ENUM[i]));
            }
        }

        int maxCount = randomNumber.nextInt((int) ((PLANTS_MAX_POPULATION + 1) * POPULATION_RATE));
        for (int i = 0; i < maxCount; i++) {
            this.cell.add(cellFill(ANIMALS_ENUM[ANIMALS_ENUM.length - 1]));
        }
    }

    public ArrayList<CellObject> getCell() {
        return cell;
    }

    @Override
    public void run() {
        createCell();
    }

    public void hunting(Cell cell) {
        ArrayList<CellObject> cellList = new ArrayList<>(cell.getCell());
        for (CellObject animal : cellList) {
            double currentSatiety = 0;

            if (animal.getClass().equals(Plants.class)) continue;
            Map<Animals, Integer> eatMap = animal.getEatingProbability();

            for (Animals animals : eatMap.keySet()) {
                Class victimClass = cellFill(animals).getClass();
                if (animal.getSatiety() <= currentSatiety) break;

                currentSatiety = currentSatiety + killObject(cellList, victimClass, eatMap, animals);

            }
            if (animal.getSatiety() > currentSatiety)
                animal.setCurrentWeight((animal.getCurrentWeight() - animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
            else if (animal.getCurrentWeight() < animal.getMaxWeight())
                animal.setCurrentWeight((animal.getCurrentWeight() + animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
        }
    }

    <T> double killObject(ArrayList<CellObject> cellList, Class<T> type, Map<Animals, Integer> eatMap, Animals animal) {
        double satiety = 0;
        for (CellObject currentAnimal : cellList) {
            if (currentAnimal.getClass().equals(type)) {
                int random = this.randomNumber.nextInt(100);
                if (random <= eatMap.get(animal)) {
                    satiety = (currentAnimal).getCurrentWeight();
                    this.cell.remove(currentAnimal);
                }
            }
        }
        return satiety;
    }

    public synchronized void weightChecker(Cell cell) {
        ArrayList<CellObject> cellList = new ArrayList<>(cell.getCell());
        for (CellObject animal : cellList) {
            if (animal.getCurrentWeight() <= (animal.getMaxWeight() * MINIMUM_WEIGHT_INDEX)) {
                this.cell.remove(animal);
            }
        }
    }

    public synchronized void reproduction(Cell cell) {
        ArrayList<CellObject> cellList = new ArrayList<>(cell.getCell());
        ArrayList<Class> classArray = new ArrayList<>();

        for (Object animal : cellList) {
            Class clazz = animal.getClass();
            if (clazz.equals(Plants.class)) continue;
            classArray.add(clazz);
        }

        for (CellObject animal : cellList) {
            int count;
            Class clazz = animal.getClass();
            if (clazz.equals(Plants.class)) continue;
            count = (int) classArray.stream().filter(clazz::equals).count();
            if ((count < animal.getMaxPopulation()) && (count >= 2) && (animal.getCurrentWeight() > (animal.getMaxWeight() * WEIGHT_INDEX_REPRODUCTION))) {
                innerReproduction(clazz);
            }
        }
    }

    void innerReproduction(Class clazz) {
        for (Animals animal : ANIMALS_ENUM) {
            CellObject currentObject = cellFill(animal);
            if (clazz.equals(currentObject.getClass())) {
                this.cell.add(currentObject);
            }
        }
    }

    public synchronized void grassGrowth(Cell cell) {
        ArrayList<CellObject> cellList = new ArrayList<>(cell.getCell());
        Plants plants = new Plants();
        int count = 0;

        for (CellObject animal : cellList) {
            Class clazz = animal.getClass();
            if (clazz.equals(Plants.class)) count++;
        }

        if (count < plants.getMaxPopulation()) {
            for (int i = 0; i < (randomNumber.nextInt((int) plants.getMaxPopulation()) * POPULATION_RATE); i++) {
                this.cell.add(new Plants());
            }
        }
    }

    public void animalMove(int y, int x){
        ArrayList<CellObject> cellList = new ArrayList<>(MY_ISLE[y][x].getCell());
        int movementSpeed;
        for (CellObject animal : cellList) {
            movementSpeed = (int) animal.getMaxSpeed();
            chooseDirection(movementSpeed,y,x,animal);
        }
    }

    void chooseDirection(int movementSpeed, int i, int j, CellObject animal){
        int moveSpeed = 0;
        if (movementSpeed > 0) moveSpeed = Math.abs(randomNumber.nextInt(movementSpeed));

        int direction = Math.abs(randomNumber.nextInt(4));

        if (moveSpeed > 0){
            if (direction == 1 && MY_ISLE[i].length > j + moveSpeed ) {
                MY_ISLE[i][j].getCell().remove(animal);
                MY_ISLE[i][j + moveSpeed].getCell().add(animal);
            }

            if (direction == 2 && i - moveSpeed > 0) {
                MY_ISLE[i][j].getCell().remove(animal);
                MY_ISLE[i - moveSpeed][j].getCell().add(animal);
            }

            if (direction == 3 && j - moveSpeed > 0) {
                MY_ISLE[i][j].getCell().remove(animal);
                MY_ISLE[i][j - moveSpeed].getCell().add(animal);
            }

            if (direction == 4 && MY_ISLE.length > i + moveSpeed ) {
                MY_ISLE[i][j].getCell().remove(animal);
                MY_ISLE[i + moveSpeed][j].getCell().add(animal);
            }
        }
    }

    public CellObject cellFill(Animals animal) {
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

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cell=" + cell.toString() +
                '}';
    }
}
