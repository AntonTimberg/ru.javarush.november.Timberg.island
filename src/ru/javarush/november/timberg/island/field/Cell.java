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

//    public void hunting(ArrayList<Object> cell){
//        Iterator<Object> cellIterator = cell.iterator();
//        while (cellIterator.hasNext()){
//            //if(o == null) continue;
//
//            double currentSatiety = 0; // задали насыщение объекта за 0
//            CellObject animal = (CellObject) cellIterator.next(); //привели типа
//            if (animal.getClass().equals(Plants.class)) continue;//если объект трава, то листаем дальше
//            Map<Animals,Integer> eatMap = animal.getEatingProbability(); //получили карту поедания
//            System.out.println();
//            for (Animals animals : eatMap.keySet()) { //двигаемся по ключам карты(зверям)
//                Class sacrClass = cellFill(animals).getClass(); //получаем класс жертвы
//                Map<Object,Double> newMap = containsType(cell,sacrClass,eatMap,animals);
//                if (newMap.keySet() != null) currentSatiety = currentSatiety + newMap.get(newMap.keySet());
//                //this.cell.remove(sacrClass.);
//                System.out.println(animal +" " +animal.getSatiety() + " " + currentSatiety);
//                if(animal.getSatiety() <= currentSatiety) break;
//
//
//                //System.out.print(animals + " ");
//            }
//            if (animal.getSatiety() > currentSatiety) animal.setCurrentWeight(animal.getCurrentWeight() * 0.9); //если не наелся, отнимаем 10% текущего веса
//            else if (animal.getCurrentWeight() < animal.getMaxWeight()) animal.setCurrentWeight(animal.getCurrentWeight() + (animal.getCurrentWeight())*0.1); //если наелся, прибавляем 10% текущего веса
//        }
//
//    }
//
//    public <T> Map<Object,Double> containsType(ArrayList<Object> list, Class<T> type, Map<Animals, Integer> eatMap, Animals animals) {
//        Map<Object,Double> resultMap = new HashMap<>();
//        Iterator<Object> cellIterator = list.iterator();
//        while (cellIterator.hasNext()){
//            Object object = cellIterator.next();
//            //if (o == null) continue;
//            if (type.isInstance(object)) {
//                int random = this.random.nextInt(100);
//                if (random <= eatMap.get(animals)) {
//                    double satiety = ((CellObject) object).getCurrentWeight();
//
//                    resultMap.put(object,satiety);
//                    //this.cell.remove(object);
//                    //cellIterator.remove();
//                    return resultMap;
//                }
//            }
//        }
//        resultMap.put(null,0.0);
//        return resultMap;
//    }
}
