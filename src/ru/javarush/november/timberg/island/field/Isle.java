package ru.javarush.november.timberg.island.field;

import static java.lang.System.out;

public class Isle {
    public static final Cell[][] MY_ISLE = new Cell[Config.ISLE_WIDTH][Config.ISLE_LENGTH];
    ShowInfo showInfo = new ShowInfo();
    public void isleCreation() {
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
                MY_ISLE[i][j] = new Cell();
                MY_ISLE[i][j].createCell();
            }
        }
    }

    public void monitor() {
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
                out.print((i+1) + "/" + (j+1) + " { " );
                showInfo.printCellInfo(MY_ISLE[i][j].getCell());
                out.println("}");
            }
        }
    }

    public void isleWorking() {
        int y = 0;
        for (Cell[] cells : MY_ISLE) {
            int x = 0;
            for (Cell currentCell : cells) {
                currentCell.hunting(currentCell);
                currentCell.weightChecker(currentCell);
                currentCell.reproduction(currentCell);
                currentCell.grassGrowth(currentCell);
                currentCell.animalMove(y,x);
                x++;
            }
            y++;
        }
    }
}
