package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.board.Board;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BoardLifeCycle {

    public static void main(String[] args) {
        Board board = new Board();

        ScheduledExecutorService animalLifeCycleExecutor =
                Executors.newScheduledThreadPool(1);

        animalLifeCycleExecutor.schedule(board::updateAnimalsState,
                1, TimeUnit.SECONDS);

//        ScheduledExecutorService plantLifeCycleExecutor =
//                Executors.newScheduledThreadPool(1);
//
//        plantLifeCycleExecutor.schedule(board::updatePlantsState,
//                1, TimeUnit.SECONDS);

        ScheduledExecutorService deadOrganismLifeCycleExecutor =
                Executors.newScheduledThreadPool(1);

        deadOrganismLifeCycleExecutor.schedule(board::removeDeadOrganism,
                300, TimeUnit.MILLISECONDS);

        ScheduledExecutorService showInfo =
                Executors.newScheduledThreadPool(1);

        showInfo.schedule(board::monitor,
                300, TimeUnit.MILLISECONDS);



    }
}
