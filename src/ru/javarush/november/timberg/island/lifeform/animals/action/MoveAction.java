package ru.javarush.november.timberg.island.lifeform.animals.action;

import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanMove;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Caterpillar;
import ru.javarush.november.timberg.island.utils.Randomizer;

import java.util.Set;

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

            for (int i = 0; i < maxSpeed; i++) {
                var nearestCells = fromCell.getNearestCells();
                var targetCellIdx = Randomizer.getRandom(0,nearestCells.size());

                toCell = nearestCells.get(targetCellIdx);
                fromCell = toCell;
            }

            if (toCell != currentCell) {
                currentCell.markDead(Set.of((Animal) targetAnimal));
            }

            toCell.add((Animal) targetAnimal);
        }
    }
}
