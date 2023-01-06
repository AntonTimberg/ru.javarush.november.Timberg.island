package ru.javarush.november.timberg.island.field;

public class Task {
    private final Cell cell;

    public Task(Cell cell) {
        this.cell = cell;
    }

ShowInfo showInfo = new ShowInfo();
    public void perform() {
//        cell.getLock().lock();
//        try {
            cell.hunting(cell);
            cell.grassGrowth(cell);
            showInfo.monitor();
           //cell.weightChecker(cell);
//        } finally {
//            cell.getLock().unlock();
//        }
    }
}
