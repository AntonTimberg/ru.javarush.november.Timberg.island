package ru.javarush.november.timberg.island.lifeform.animals.action;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanReproduce;
import ru.javarush.november.timberg.island.utils.Randomizer;

import java.util.concurrent.atomic.AtomicInteger;
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
        var random = Randomizer.getRandom(1,4);
        if (random == 1){
            var partners = currentCell.getOrganisms().stream()
                    .filter(organism -> organism.getState() != State.DEAD && !organism.equals(targetAnimal)
                            && organism.getClass().equals(targetAnimal.getClass()))
                    .collect(Collectors.toList());

            AtomicInteger count =
                    new AtomicInteger(Cell.MAX_ANIMAL_POPULATIONS.get(targetAnimal.getAnimalType()) - 1);
            if (partners.size() < count.get()){
                AtomicInteger i = new AtomicInteger(0);
                for (i.get(); i.get() < (count.get() - partners.size()); i.getAndIncrement()) {
                    currentCell.add(Cell.createAnimal(targetAnimal.getAnimalType()));
                    count.getAndDecrement();
                }
            }
        }
    }
}