package ru.javarush.november.timberg.island.lifeform;

import ru.javarush.november.timberg.island.board.BoardSetting;
import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.animals.action.Action;

import static ru.javarush.november.timberg.island.board.BoardSetting.PLANTS_WEIGHT;

public class Plant implements Organism {
    private State state = State.ALIVE;

    @Override
    public double getMaxWeight() {
        return PLANTS_WEIGHT;
    }


    public double getMaxPopulation() {
        return BoardSetting.PLANTS_MAX_POPULATION;
    }


    public int getMaxSpeed() {
        return BoardSetting.PLANTS_MAX_SPEED;
    }

    @Override
    public String getUnicode() {
        return BoardSetting.PLANTS_UNICODE;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Action whatDoYouWant(Cell cell) {
        return null;
    }

    @Override
    public void updateState() {
    }

    @Override
    public String toString() {
        return "Plant " + getUnicode();
    }

    public double getCurrentWeight() {
        return PLANTS_WEIGHT;
    }

    public void setState(State state) {
        this.state = state;
    }
}
