package ru.javarush.november.timberg.island.lifeform.animals.action;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanEat;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class EatAction implements Action {

    private final CanEat targetAnimal;
    private final Cell currentCell;

    public EatAction(CanEat targetAnimal, Cell currentCell) {
        this.targetAnimal = targetAnimal;
        this.currentCell = currentCell;
    }

    @Override
    public void run() {
        var food = currentCell.getOrganisms().stream()
                .filter(organism -> organism.getState() != State.DEAD
                        && !organism.equals(targetAnimal))
                .filter(organism -> {
                    var expectedProbability = ((Animal) targetAnimal).
                            getProbability(((Animal) targetAnimal).getProbabilityMap(),organism);
                    var realProbability = Math.random();
                    return realProbability <= expectedProbability;
                })
                .collect(Collectors.toList());

        List<Organism> victims = ((Animal) targetAnimal).eat(food,targetAnimal);
        currentCell.markDead(new HashSet<>(victims));
    }
}
