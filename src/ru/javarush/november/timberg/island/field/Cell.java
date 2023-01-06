package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.LivingObject;
import ru.javarush.november.timberg.island.living_objects.Plants;
import ru.javarush.november.timberg.island.living_objects.animals.AbstractAnimal;
import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.herbivores.*;
import ru.javarush.november.timberg.island.living_objects.animals.predators.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ru.javarush.november.timberg.island.field.Config.*;
import static ru.javarush.november.timberg.island.field.IsleBoard.myIsle;
import static ru.javarush.november.timberg.island.field.Randomizer.getProbability;

public class Cell {
    protected ArrayList<LivingObject> cell = new ArrayList<>();
    protected static final AnimalType[] ANIMAL_TYPE_ENUM = AnimalType.values();
    Random randomNumber = new Random();

    //Randomizer randomizer = new Randomizer();

    private final Lock lock = new ReentrantLock(true);

    public synchronized void createCell() {
        for (int i = 0; i < ANIMAL_TYPE_ENUM.length - 1; i++) {
            AbstractAnimal abstractAnimal = (AbstractAnimal) cellFill(ANIMAL_TYPE_ENUM[i]);
            int maxCount = (int) (((int) abstractAnimal.getMaxPopulation()) * POPULATION_RATE);
            int random = randomNumber.nextInt(maxCount);
            for (int j = 0; j < random; j++) {
                this.cell.add(cellFill(ANIMAL_TYPE_ENUM[i]));
            }
        }

        int maxCount = randomNumber.nextInt((int) ((PLANTS_MAX_POPULATION + 1) * POPULATION_RATE));
        for (int i = 0; i < maxCount; i++) {
            this.cell.add(cellFill(AnimalType.PLANTS));
        }
    }

    public ArrayList<LivingObject> getCell() {
        return cell;
    }

//    @Override
//    public void run() {
//        grassGrowth();
//    }

    public void grassGrowth(Cell cell) {
        ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
        Plants plants = new Plants();
        int count = 0;

        for (LivingObject animal : cellList) {
            Class clazz = animal.getClass();
            if (clazz.equals(Plants.class)) count++;
        }

        if (count < plants.getMaxPopulation()) {
            for (int i = 0; i < (randomNumber.nextInt((int) plants.getMaxPopulation()) * POPULATION_RATE); i++) {
                this.cell.add(new Plants());
            }
        }
    }


//    public void hunting(AbstractAnimal animal, Cell cell) {
//        cell.getLock().lock();
//        ArrayList<LivingObject> cellList = new ArrayList<>();
//        cellList.addAll(cell.getCell());
//        Map<AnimalType, Integer> eatMap = animal.getEatingProbability();
//
//        for (LivingObject livingObject : cellList) {
//            if (animal.getCurrentSatiety() >= animal.getMaxSatiety()) break;
//            for (AnimalType animalType : eatMap.keySet()) {
////                killAnimal(livingObject, animalType, eatMap, animal, cell);
//                if (cellFill(animalType).getClass().equals(livingObject.getClass())) {
//                    if (getProbability(eatMap.get(animalType))) {
//                        out.println(livingObject.getCurrentWeight());
//                        out.println(livingObject);
//                        animal.setSatiety(animal.getCurrentSatiety() + livingObject.getCurrentWeight());
//                        cell.remove(livingObject);
//                    }
//                }
//            }
//        }
//
//        if (animal.getMaxSatiety() > animal.getCurrentSatiety())
//            animal.setCurrentWeight((animal.getCurrentWeight() - animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
//        else if (animal.getCurrentWeight() < animal.getMaxWeight())
//            animal.setCurrentWeight((animal.getCurrentWeight() + animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
//        //animal.setSatiety(0); установишь потом на проверке веса
//        cell.getLock().unlock();
//    }

//    private void killAnimal(LivingObject livingObject, AnimalType animalType,
//                            Map<AnimalType, Integer> eatMap, AbstractAnimal animal, Cell cell){
//        if (cellFill(animalType).getClass().equals(livingObject.getClass())) {
//            if (getProbability(eatMap.get(animalType))) {
//                out.println(livingObject.getCurrentWeight());
//                out.println(livingObject);
//                animal.setSatiety(animal.getCurrentSatiety() + livingObject.getCurrentWeight());
//                cell.remove(livingObject);
//            }
//        }
//    }

    public Lock getLock() {
        return lock;
    }

    public void remove(LivingObject object) {
        cell.remove(object);
    }

    public void hunting(Cell cell) {

            ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
            for (LivingObject animal : cellList) {
                double currentSatiety = 0;

                if (animal.getClass().equals(Plants.class)) continue;
                Map<AnimalType, Integer> eatMap = ((AbstractAnimal) animal).getEatingProbability();

                for (AnimalType animalType : eatMap.keySet()) {
                    Class victimClass = cellFill(animalType).getClass();
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


    public void weightChecker(Cell cell) {

            ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
            for (LivingObject animal : cellList) {
                if (animal.getClass().equals(Plants.class)) continue;
                if (animal.getCurrentWeight() <= (animal.getMaxWeight() * MINIMUM_WEIGHT_INDEX)) {
                    //out.println(animal + " убит!");
                    this.cell.remove(animal);
                }
                //else ((AbstractAnimal) animal).setSatiety(0);
            }

    }

    //    public void hunting(Cell cell) {
//        ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
//        for (LivingObject animal : cellList) {
//            double currentSatiety = 0;
//
//            if (animal.getClass().equals(Plants.class)) continue;
//            Map<AnimalType, Integer> eatMap = ((AbstractAnimal)animal).getEatingProbability();
//
//            for (AnimalType animals : eatMap.keySet()) {
//                Class victimClass = cellFill(animals).getClass();
//                if (animal.getMaxSatiety() <= currentSatiety) break;
//
//                currentSatiety = currentSatiety + killObject(cellList, victimClass, eatMap, animals);
//
//            }
//            if (animal.getSatiety() > currentSatiety)
//                animal.setCurrentWeight((animal.getCurrentWeight() - animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
//            else if (animal.getCurrentWeight() < animal.getMaxWeight())
//                animal.setCurrentWeight((animal.getCurrentWeight() + animal.getCurrentWeight() * WEIGHT_CHANGE_INDEX));
//        }
//    }
//
    public synchronized void reproduction(Cell cell) {
        ArrayList<LivingObject> cellList = new ArrayList<>(cell.getCell());
        ArrayList<Class> classArray = new ArrayList<>();

        for (Object animal : cellList) {
            Class clazz = animal.getClass();
            if (clazz.equals(Plants.class)) continue;
            classArray.add(clazz);
        }

        for (LivingObject animal : cellList) {
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
        for (AnimalType animal : ANIMAL_TYPE_ENUM) {
            LivingObject currentObject = cellFill(animal);
            if (clazz.equals(currentObject.getClass())) {
                this.cell.add(currentObject);
            }
        }
    }

    public synchronized void animalMove(int y, int x) {
        ArrayList<LivingObject> cellList = new ArrayList<>(myIsle[y][x].getCell());
        int movementSpeed;
        for (LivingObject animal : cellList) {
            movementSpeed = (int) animal.getMaxSpeed();
            chooseDirection(movementSpeed, y, x, animal);
        }
    }

    void chooseDirection(int movementSpeed, int i, int j, LivingObject animal) {
        int moveSpeed = 0;
        if (movementSpeed > 0) moveSpeed = Math.abs(randomNumber.nextInt(movementSpeed));

        int direction = Math.abs(randomNumber.nextInt(4));

        if (moveSpeed > 0) {
            if (direction == 1 && myIsle[i].length > j + moveSpeed) {
                myIsle[i][j].getCell().remove(animal);
                myIsle[i][j + moveSpeed].getCell().add(animal);
            }

            if (direction == 2 && i - moveSpeed > 0) {
                myIsle[i][j].getCell().remove(animal);
                myIsle[i - moveSpeed][j].getCell().add(animal);
            }

            if (direction == 3 && j - moveSpeed > 0) {
                myIsle[i][j].getCell().remove(animal);
                myIsle[i][j - moveSpeed].getCell().add(animal);
            }

            if (direction == 4 && myIsle.length > i + moveSpeed) {
                myIsle[i][j].getCell().remove(animal);
                myIsle[i + moveSpeed][j].getCell().add(animal);
            }
        }
    }

    public LivingObject cellFill(AnimalType animal) {
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

    @Override
    public String toString() {
        return "Cell{" +
                "cell=" + cell.toString() +
                '}';
    }
}
