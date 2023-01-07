package ru.javarush.november.timberg.island.board;


import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.State;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Board {
    private final Cell[][] cells;
    private final BoardSetting setting;

    public Board() {
        this(BoardSetting.DEFAULT);
    }

    public Board(BoardSetting setting) {
        this.setting = setting;

        // инициализация доски
        cells = new Cell[setting.getWidth()][setting.getLength()];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = Cell.create();
            }
        }

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (j != 0) {
                    var left = cells[i][j - 1];
                    cells[i][j].addNearestCell(left);
                }

                if ((j + 1) < cells[i].length) {
                    var right = cells[i][j + 1];
                    cells[i][j].addNearestCell(right);
                }

                if (i != 0) {
                    var up = cells[i - 1][j];
                    cells[i][j].addNearestCell(up);
                }

                if ((i + 1) < cells.length) {
                    var down = cells[i + 1][j];
                    cells[i][j].addNearestCell(down);
                }
            }
        }
    }

    public BoardSetting getSetting() {
        return setting;
    }

    // calling asynchronously
    public void removeDeadOrganism() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                var cell = cells[i][j];
                var deadOrganisms = cell.getOrganisms().stream()
                        .filter(organism -> State.DEAD == organism.getState())
                        .collect(Collectors.toSet());
                cell.remove(deadOrganisms);
            }
        }
    }

    public void monitor() {
        out.println("|||||NEW CYCLE|||||");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                    out.print((i + 1) + "/" + (j + 1) + " { ");
                    printCellInfo(cells[i][j].getOrganisms());
                    out.println("}");
            }
        }
    }

    public void printCellInfo(List cell) {
        ArrayList<Class> classArrayList = new ArrayList<>();
        for (Object animal : cell) {
            Organism object = (Organism) animal;
            int count = (int) cell.stream().filter(animal.getClass()::isInstance).count();
            if (!classArrayList.contains(animal.getClass())) System.out.print(object.getUnicode() + "=" + count + " ");
            classArrayList.add(animal.getClass());
        }
    }

    // calling asynchronously
    // cell -> list<LivingObject> objects
    public void updateAnimalsState() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                var cell = cells[i][j];
                for (Animal animal : cell.getAnimals()) {
                    if (animal.getState() == State.ALIVE) {
                        var action = animal.whatDoYouWant(cell);
                        action.run();
                        animal.updateState();
                    }
                }
            }
        }
    }



    // calling asynchronously
    public void updatePlantsState() {
        // creating plants
    }
}
