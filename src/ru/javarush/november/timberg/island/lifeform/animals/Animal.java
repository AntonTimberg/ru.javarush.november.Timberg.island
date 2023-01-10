package ru.javarush.november.timberg.island.lifeform.animals;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.action.Action;
import ru.javarush.november.timberg.island.lifeform.animals.action.EatAction;
import ru.javarush.november.timberg.island.lifeform.animals.action.MoveAction;
import ru.javarush.november.timberg.island.lifeform.animals.action.ReproduceAction;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanEat;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanMove;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanReproduce;
import ru.javarush.november.timberg.island.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public abstract class Animal implements Organism, CanEat, CanMove, CanReproduce {
    protected double currentWeight = (double) Math.round((Math.random()
            * (getMaxWeight() - (getMaxWeight() * MINIMUM_WEIGHT_INDEX) + 1)
            + (getMaxWeight() * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
    protected double satiety = getMaxSatiety() * START_SATIETY_INDEX;
    protected State state = State.ALIVE;

    @Override
    public Action whatDoYouWant(Cell cell) {
        if (getCurrentSatiety() < getMaxSatiety()) {
            return new EatAction(this, cell);
        }
        var i = Randomizer.getRandom(1 , 2);
        if (i == 1 && this.getCurrentWeight() >= WEIGHT_INDEX_REPRODUCTION) {
            return new ReproduceAction(this, cell);
        }
        return new MoveAction(this, cell);
    }

    public abstract AnimalType getAnimalType();
    @Override
    public double getCurrentSatiety() {
        return satiety;
    }

    @Override
    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight){
        this.currentWeight = currentWeight;
    }

    @Override
    public void setCurrentSatiety(Double satiety){
        this.satiety = satiety;
    }
    @Override
    public State getState() {
        return state;
    }

    public abstract Map<Class<? extends Organism>, Double> getProbabilityMap();

    public double getProbability(Map<Class<? extends Organism>, Double> probabilities,Organism victim) {
        return probabilities.getOrDefault(victim.getClass(), 0.0D);
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void updateState() {
        if((this.getCurrentSatiety() >= this.getMaxSatiety())&&(this.getCurrentWeight() < this.getMaxWeight())){
            this.setCurrentWeight(this.getCurrentWeight() + this.currentWeight * WEIGHT_CHANGE_INDEX);
        }

        if(this.getCurrentSatiety() < this.getMaxSatiety()){
            this.setCurrentWeight(this.getCurrentWeight() - this.currentWeight * WEIGHT_CHANGE_INDEX);
        }

        if (this.currentWeight <= (this.getMaxWeight()*MINIMUM_WEIGHT_INDEX)) this.setState(State.DEAD);
        this.setCurrentSatiety(0D);
    }

    public List<Organism> eat(List<Organism> organisms, CanEat targetAnimal) {
        List<Organism> victims = new ArrayList<>();
        for (Organism organism : organisms) {
            if ((targetAnimal.getCurrentSatiety()) < (targetAnimal.getMaxSatiety())){
                victims.add(organism);
            }
            targetAnimal.setCurrentSatiety(targetAnimal.getCurrentSatiety() + organism.getCurrentWeight());
        }
        return victims;
    }
}
