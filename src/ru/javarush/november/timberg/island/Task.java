package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.Cell;
import ru.javarush.november.timberg.island.field.ShowInfo;

public class Task {
    ShowInfo showInfo = new ShowInfo();
    private final Cell cell;
    public Task(Cell cell){
        this.cell = cell;
    }

    public void perform() {
        showInfo.monitor();
        cell.hunting(cell);
        cell.weightChecker(cell);
        cell.reproduction(cell);
        cell.grassGrowth(cell);
    }
}
