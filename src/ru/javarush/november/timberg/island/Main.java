package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ru.javarush.november.timberg.island.field.Config.ISLE_LENGTH;
import static ru.javarush.november.timberg.island.field.Config.ISLE_WIDTH;
import static ru.javarush.november.timberg.island.field.IsleBoard.myIsle;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        // Создание осторова (плоская доска) c заданной размерностью (2D)
        IsleBoard board = new IsleBoard(ISLE_WIDTH, ISLE_LENGTH);
        Cell cell = new Cell();

//        ScheduledExecutorService executorInfo = Executors.newScheduledThreadPool(1);
//        //ScheduledExecutorService executorWeightCheck = Executors.newScheduledThreadPool(1);
//        //ScheduledExecutorService executorHunting = Executors.newScheduledThreadPool(1);
//        ScheduledExecutorService grassGrowthExecutor = Executors.newScheduledThreadPool(1);
//
//
//
//        executorInfo.scheduleWithFixedDelay(new ShowInfo(), 1, 1, TimeUnit.SECONDS);



//        for (int i = 0; i < myIsle.length; i++) {
//            for (int j = 0; j < myIsle[i].length; j++) {
//                //executorHunting.scheduleWithFixedDelay(new Hunting(myIsle[i][j]), 2,2,TimeUnit.SECONDS);
//                //executorWeightCheck.scheduleWithFixedDelay(new WeightChecker(myIsle[i][j]), 4, 4, TimeUnit.SECONDS);
//                //grassGrowthExecutor.scheduleWithFixedDelay(new GrassGrowth(myIsle[i][j]), 2 , 2, TimeUnit.SECONDS);
//                grassGrowthExecutor.scheduleWithFixedDelay(new Task(myIsle[i][j]), 2 , 3, TimeUnit.SECONDS);
//            }
//        }


//        Cell cell = new Cell();
//        AtomicInteger i = new AtomicInteger(0);
//        AtomicInteger j = new AtomicInteger(0);
//        for (LivingObject livingObject : myIsle[0][0].getCell()) {
//
//            System.out.println(((AbstractAnimal) livingObject).getCurrentSatiety());
//            cell.hunting((AbstractAnimal) livingObject, myIsle[0][0]);
//            System.out.println(((AbstractAnimal) livingObject).getCurrentSatiety());
//            break;
//        }


//        executorService.scheduleAtFixedRate(() -> {
//            for (Cell[] cells : myIsle) {
//                for (Cell innerCell : cells) {
////                        Iterator<LivingObject> livingObjectIterator = innerCell.getCell().iterator();
////                        while(livingObjectIterator.hasNext()){
////                            if(livingObjectIterator.next().getClass().equals(Plants.class)) continue;
////                            //System.out.println(((AbstractAnimal) livingObjectIterator.next()).getCurrentSatiety());
////                            innerCell.hunting((AbstractAnimal) livingObjectIterator.next(), innerCell);
////                            //System.out.println(((AbstractAnimal) livingObjectIterator.next()).getCurrentSatiety());
////                        }
////                        for (LivingObject livingObject : innerCell.getCell()) {
////                            if (livingObject.getClass().equals(Plants.class)) continue;
////                            System.out.println(((AbstractAnimal) livingObject).getCurrentSatiety());
////                            innerCell.hunting((AbstractAnimal) livingObject, innerCell);
////                            System.out.println(((AbstractAnimal) livingObject).getCurrentSatiety());
////                        }
//                    innerCell.hunting(innerCell);
//                    //innerCell.grassGrowth(innerCell);
//                    //innerCell.weightChecker(innerCell);
//                }
//            }
//            //board.updateState();
//        }, 1, 3, TimeUnit.SECONDS);





//
//        executorService.scheduleAtFixedRate(() -> {
//            for (Cell[] cells : myIsle) {
//                for (Cell innerCell : cells) {
//                    innerCell.reproduction(innerCell);
//                }
//            }
//        }, 1, 7, TimeUnit.SECONDS);

//        executorService.scheduleAtFixedRate(() -> {
//            for (i.get(); i.get() < myIsle.length; i.incrementAndGet()) {
//                for (j.get(); j.get() < myIsle[i.get()].length; j.incrementAndGet()) {
//                    myIsle[i.get()][j.get()].animalMove(i.get(),j.get());
//                }
//            }
//        }, 1, 5, TimeUnit.SECONDS);


//        ArrayList<Runnable> tasks = new ArrayList<>();
//        for (int y = 0; y < myIsle.length; y++) {
//            for (int x = 0; x < myIsle[y].length; x++) {
//                int finalY = y;
//                int finalX = x;
//                tasks.add(() -> {
//                    showInfo.monitor();
//                });
//
//            }
//        }
//        executorService.scheduleAtFixedRate(() -> {
//
//            showInfo.monitor();
//            for (Cell[] cells : myIsle) {
//                for (Cell cell1 : cells) {
//                    //cell1.hunting(cell1);
//                    cell1.grassGrowth(cell1);
//                    cell1.weightChecker(cell1);
//                }
//            }
//
//        }, 1, 5, TimeUnit.SECONDS);

    }


}
