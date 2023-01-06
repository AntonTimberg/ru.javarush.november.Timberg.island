package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.LivingObject;

import java.awt.geom.Area;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static ru.javarush.november.timberg.island.field.IsleBoard.myIsle;


public class Worker implements Runnable{
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();
    @Override
    public void run() {
        Cell[][] areas = myIsle;
        for (Cell[] cells : myIsle) {
            for (Cell cell : cells) {
                createTasksForArea(cell);
            }
        }
    }
    private void createTasksForArea(Cell area) {
            area.getLock().lock(); // ONLY READ - AND NOW ONLY MAKES TASK
            try {

                    tasks.add(new Task(area));

            } finally {
                area.getLock().unlock();
            }


        tasks.forEach(Task::perform);
        tasks.clear();
    }
}
