package ru.javarush.november.timberg.island.lifeform.animals.action;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanReproduce;
import ru.javarush.november.timberg.island.utils.Randomizer;

import java.util.stream.Collectors;


public class ReproduceAction implements Action{

    private final Animal targetAnimal;
    private final Cell currentCell;
    public ReproduceAction(CanReproduce targetAnimal, Cell currentCell) {
        this.targetAnimal = (Animal) targetAnimal;
        this.currentCell = currentCell;
    }

    @Override
    public void run() {
        var random = Randomizer.getRandom(1,3);
        if (random == 1){
            var partners = currentCell.getOrganisms().stream()
                    .filter(organism -> organism.getState() != State.DEAD && !organism.equals(targetAnimal)
                            && organism.getClass().equals(targetAnimal.getClass()))
                    .collect(Collectors.toList());

            int count = targetAnimal.getMaxPopulation() - 1;

            if (partners.size() < count){
                for (int i = 0; i < (count - partners.size()); i++) {
                    currentCell.add(Cell.createAnimal(targetAnimal.getAnimalType()));
                    count--;
                }
            }
        }
    }
}