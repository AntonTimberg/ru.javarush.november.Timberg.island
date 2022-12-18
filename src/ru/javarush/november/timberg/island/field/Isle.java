package ru.javarush.november.timberg.island.field;

import java.util.*;

public class Isle {
    public static Cell[][] MY_ISLE = new Cell[Config.ISLE_WIDTH][Config.ISLE_LENGTH];
    //ExecutorService cringeService = Executors.newCachedThreadPool();
    Cell cell = new Cell();
    Random random = new Random();
    public void isle_Creation(){
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
               // MY_ISLE[i][j] = cringeService.submit(cell);
                MY_ISLE[i][j] = new Cell();
                MY_ISLE[i][j].createCell();
            }
        }
    }

    @Override
    public String toString() {
        return "Isle{" +
                "MY_ISLE=" + Arrays.toString(MY_ISLE) +
                '}';
    }

//    public Map<Enum,Integer> hunting(CellObject currentObject, ArrayList<Object> cell){
//
//        Map<Animals, Integer> map = currentObject.getEatingProbability();
//        //System.out.println(map.toString());
//        Map<Animals, Integer> mapForHunting = new HashMap<>();
//        for (Animals animals : map.keySet()) {
//            for (Object o : cell) {
//                if (o.getClass().equals(this.cell.cellFill(animals).getClass())) mapForHunting.put(animals,map.get(animals)); //проверяем наличие животного в клетке с охотником, добавляем его в карту охоты
//            }
//
//        }
//        //out.println(mapForHunting.entrySet()); //проверочный
//
//        int huntRandom = random.nextInt(map.size());
//        int count = 0;
//        for (Animals animals : mapForHunting.keySet()) {
//            if(count == huntRandom) {
//                Map<Enum, Integer> result = new HashMap<>();
//                result.put(animals,mapForHunting.get(animals));
//                return result;
//            }
//            count++;
//        }
//        return null;
//    }
//
//    public Map<Enum, Integer> objectEnumeration(ArrayList<Object> cell){
//        for (Object animal : cell) { //перебор объектов клетки
//            if (animal.getClass() != Plants.class) { //работа с выбором охотника
//                CellObject cellObject = (CellObject) animal;
//                double objectMaxSaturation = cellObject.getSaturation();
//                //System.out.println(objectMaxSaturation);
//                //out.println(hunting((CellObject) animal));
//                double currentSaturation = 0;
//                for (int i = 0; i < TRY_HUNTING_COUNT; i++) {
//                    if (currentSaturation >= objectMaxSaturation) break;
//                    int innerRandom = random.nextInt(100);
//                    Map<Enum, Integer> map = hunting(cellObject, cell); // предполагаемая жертва и шанс охоты
//                    if(innerRandom >= map.get(map.keySet())){
//                        for (Object o : cell) {
//                           // if (o.getClass().equals(this.cell.cellFill(map.key).getClass()))
//                        }
//                    }
//                }
//
//            }
//        }
//        return null;
//    }
//
//    public void cellEnumeration(){ //перебор клеток острова
//        for (Cell[] cell : MY_ISLE) {
//            for (Cell innerCell : cell) {
//                objectEnumeration(innerCell.getCell());
//            }
//        }
//    }
//
//    public void tryer(){
//
//    }
}
