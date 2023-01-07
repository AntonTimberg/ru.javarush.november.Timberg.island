package ru.javarush.november.timberg.island.lifeform.animals.action;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanMove;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Caterpillar;
import ru.javarush.november.timberg.island.utils.Randomizer;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class MoveAction implements Action {
    private final CanMove targetAnimal;
    private final Cell currentCell;

    public MoveAction(CanMove targetAnimal, Cell currentCell) {
        this.targetAnimal = targetAnimal;
        this.currentCell = currentCell;
    }

    @Override
    public void run() {
        if(!targetAnimal.getClass().equals(Caterpillar.class)){
            var maxSpeed = targetAnimal.getMaxSpeed();

            var fromCell = currentCell;
            var toCell = currentCell;

            AtomicInteger i = new AtomicInteger(0);
            for (i.get(); i.get() < maxSpeed; i.getAndIncrement()) {
                var nearestCells = fromCell.getNearestCells();
                var targetCellIdx = Randomizer.getRandom(0,nearestCells.size());

                toCell = nearestCells.get(targetCellIdx);
                fromCell = toCell;
            }

            // check current != toCell
            if (toCell != currentCell) {
                currentCell.markDead(Set.of((Animal) targetAnimal));
            }

            toCell.add((Animal) targetAnimal);
        }
    }
}
