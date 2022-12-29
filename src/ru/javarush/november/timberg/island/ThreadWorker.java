package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.Cell;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static ru.javarush.november.timberg.island.field.Isle.MY_ISLE;


public class ThreadWorker implements Runnable{
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();
    Cell cell = new Cell();
    @Override
    public void run(){
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
                createTaskForCell(MY_ISLE[i][j]);
                cell.animalMove(i,j);
                System.out.println("=================================");
            }
        }
    }

    private void createTaskForCell(Cell cell){
        cell.getLock().lock();
        try {
            tasks.add(new Task(cell));
        } finally {
            cell.getLock().unlock();
        }
        tasks.forEach(Task::perform);
        tasks.clear();
    }
}

