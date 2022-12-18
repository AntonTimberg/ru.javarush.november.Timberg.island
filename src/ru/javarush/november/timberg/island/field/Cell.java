package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animal;
import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.herbivores.*;
import ru.javarush.november.timberg.island.animals.predators.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

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

    public Object cellFill(Animals animal) {
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

    public void hunting(ArrayList<Object> cell){
        for (Object o : cell) {
            double currentSaturation = 0; // задали насыщение объекта за 0
            CellObject animal = (CellObject) o; //привели типа
            if (animal.getClass().equals(Plants.class)) continue;//если объект трава, то листаем дальше
            Map<Animals,Integer> eatMap = animal.getEatingProbability(); //получили карту поедания
            System.out.println();
            for (Animals animals : eatMap.keySet()) { //двигаемся по ключам карты(зверям)
                Class sacrClass = cellFill(animals).getClass(); //получаем класс жертвы

                currentSaturation = currentSaturation + containsType(cell,sacrClass,eatMap,animals);

                System.out.println(animal +" " +animal.getSaturation() + " " + currentSaturation);
                if(animal.getSaturation() <= currentSaturation) break;


                //System.out.print(animals + " ");
            }

        }
    }

    public <T> double containsType(ArrayList<Object> list, Class<T> type, Map<Animals, Integer> eatMap, Animals animals) {
        for (Object o : list) {
            if (type.isInstance(o)) {
                int random = this.random.nextInt(100);
                if (random >= eatMap.get(animals)) {
                    double saturation = ((CellObject) o).getCurrentWeight();
                    //list.remove(o);
                    return saturation;
                }
            }
        }
        return 0;
    }
}
