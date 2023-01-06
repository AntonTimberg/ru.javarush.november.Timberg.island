package ru.javarush.november.timberg.island.field;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Th implements Runnable{
    ShowInfo showInfo = new ShowInfo();
    @Override
    public void run() {
        showInfo.monitor();
        ScheduledExecutorService gameScheduledThreadPool = Executors.newScheduledThreadPool(8);
        gameScheduledThreadPool.scheduleWithFixedDelay(new Worker(),2, 2, TimeUnit.MILLISECONDS);
    }
}
