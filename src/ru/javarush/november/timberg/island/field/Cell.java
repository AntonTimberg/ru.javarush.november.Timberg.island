package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animal;
import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Plants;
import ru.javarush.november.timberg.island.animals.herbivores.*;
import ru.javarush.november.timberg.island.animals.predators.*;

import java.util.*;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Cell implements Runnable{
    public ArrayList<Object> cell = new ArrayList<>();
    public static Animals[] animalsEnum = Animals.values();
    Random random = new Random();

    public void createCell() {
        for (int i = 0; i < animalsEnum.length - 1; i++) {
            Animal x = (Animal) cellFill(animalsEnum[i]);
            int maxCount = (int)(((int) x.getMaxPopulation()) * POPULATION_RATE);
            int random = (int) (Math.random() * ++maxCount) ;
            for (int j = 0; j < random; j++) {
                this.cell.add(cellFill(animalsEnum[i]));
            }
        }

        int maxCount = (int) (Math.random() * (int)((PLANTS_MAX_POPULATION + 1) * POPULATION_RATE));
        for (int i = 0; i < maxCount; i++) {
            this.cell.add(cellFill(animalsEnum[animalsEnum.length - 1]));
        }
    }

    public void removeAnimal(Object animal){
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
            double currentSatiety = 0;
            CellObject animal = (CellObject) object;
            if (animal.getClass().equals(Plants.class)) continue;
            Map<Animals,Integer> eatMap = animal.getEatingProbability();

            for (Animals animals : eatMap.keySet()) {
                Class sacrClass = cellFill(animals).getClass();
                if(animal.getSatiety() <= currentSatiety) break;

                currentSatiety = currentSatiety + killFirst(cellList,sacrClass,eatMap,animals);

            }
            if (animal.getSatiety() > currentSatiety) animal.setCurrentWeight(((double) Math.round(animal.getCurrentWeight() * 0.9)*100)/100); //если не наелся, отнимаем 10% текущего веса
            else if (animal.getCurrentWeight() < animal.getMaxWeight()) animal.setCurrentWeight((double) Math.round((animal.getCurrentWeight() + (animal.getCurrentWeight())*0.1)*1000)/1000); //если наелся, прибавляем 10% текущего веса
            //if (currentSatiety == 0) animal.setCurrentWeight((double) Math.round((animal.getCurrentWeight() + (animal.getCurrentWeight())*0.1)*100)/100);
        }
    }

    public <T> double killFirst(ArrayList<Object> cellList, Class<T> type, Map<Animals, Integer> eatMap, Animals animal){
        double satiety = 0;
        for (Object o : cellList) {
            if (o.getClass().equals(type)) {
                int random = this.random.nextInt(100);
                if (random <= eatMap.get(animal)) {
                    satiety = ((CellObject) o).getCurrentWeight();
                    this.cell.remove(o);
                    System.out.print(cellFill(animal).toString() + " умерщвлён  ");
                }
            }
        }
        return satiety;
    }
    
    public void weightChecker(Cell cell){
        System.out.println();
        ArrayList<Object> cellList = new ArrayList<>(cell.getCell());
        for (Object object : cellList) {
            CellObject animal = (CellObject) object;
            if(animal.getCurrentWeight() <= (animal.getMaxWeight()*0.55)) {this.cell.remove(object);
                System.out.print(object.toString() + " умер от потери веса ");}
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
