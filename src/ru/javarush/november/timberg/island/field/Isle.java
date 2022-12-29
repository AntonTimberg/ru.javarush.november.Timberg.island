package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.ThreadWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Isle extends Thread{
    public static final Cell[][] MY_ISLE = new Cell[Config.ISLE_WIDTH][Config.ISLE_LENGTH];
    public void isleCreation() {
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
                MY_ISLE[i][j] = new Cell();
                MY_ISLE[i][j].createCell();
            }
        }
    }

    @Override
    public void run(){
        ScheduledExecutorService gameScheduledThreadPool = Executors.newScheduledThreadPool(4);
        gameScheduledThreadPool.scheduleWithFixedDelay(this::runAndWait, 1000, 2000, TimeUnit.MILLISECONDS);
    }

    private void runAndWait(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        fixedThreadPool.submit(new ThreadWorker());
    }
}
