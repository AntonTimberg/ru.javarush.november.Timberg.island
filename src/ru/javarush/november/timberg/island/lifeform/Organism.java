package ru.javarush.november.timberg.island.lifeform;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.animals.action.Action;

public interface Organism {

    double getCurrentWeight();

    double getMaxWeight();

    int getMaxPopulation();

    String getUnicode();

    State getState();

    Action whatDoYouWant(Cell cell);

    void updateState();
}
