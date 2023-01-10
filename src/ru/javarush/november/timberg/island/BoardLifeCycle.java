package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.board.Board;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BoardLifeCycle {

    public static void main(String[] args) {
        Board board = new Board();

        ScheduledExecutorService showInfo =
                Executors.newScheduledThreadPool(1);

        showInfo.scheduleAtFixedRate(board::monitor,
                200, 2000,TimeUnit.MILLISECONDS);

        ScheduledExecutorService animalLifeCycleExecutor =
                Executors.newScheduledThreadPool(1);

        animalLifeCycleExecutor.scheduleAtFixedRate(board::updateAnimalsState,
                1, 1, TimeUnit.SECONDS);

        ScheduledExecutorService plantLifeCycleExecutor =
                Executors.newScheduledThreadPool(1);

        plantLifeCycleExecutor.scheduleWithFixedDelay(board::updatePlantsState,
                1,4,TimeUnit.SECONDS);

        ScheduledExecutorService deadOrganismLifeCycleExecutor =
                Executors.newScheduledThreadPool(1);

        deadOrganismLifeCycleExecutor.scheduleAtFixedRate(board::removeDeadOrganism,
                300,300, TimeUnit.MILLISECONDS);

    }
}
