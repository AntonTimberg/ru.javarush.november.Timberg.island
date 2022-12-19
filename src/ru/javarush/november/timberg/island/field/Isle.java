package ru.javarush.november.timberg.island.field;

import java.util.*;

import static java.lang.System.out;

public class Isle {
    public static Cell[][] MY_ISLE = new Cell[Config.ISLE_WIDTH][Config.ISLE_LENGTH];
    //ExecutorService cringeService = Executors.newCachedThreadPool();
    Cell cell = new Cell();
    Random random = new Random();
    public void isle_Creation(){
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
               // MY_ISLE[i][j] = cringeService.submit(cell);
                MY_ISLE[i][j] = new Cell();
                MY_ISLE[i][j].createCell();
            }
        }
    }

    @Override
    public String toString() {
        return "Isle{" +
                "MY_ISLE=" + Arrays.toString(MY_ISLE) +
                '}';
    }

    public void isleWorking(){
    int x = 0;
    int y = 0;
        out.println();
            for (Cell[] cells : this.MY_ISLE) {
                y++;
                for (Cell cell3 : cells) {
                    x++;
                    out.print("Ячейка острова- " + y+" "+x+":  ");
                    for (Object object : cell3.getCell()) {
                        CellObject currentObject = (CellObject) object;
                        out.print(currentObject.toString());
                        out.print(":весом " + currentObject.getCurrentWeight() + " кг.  ");
                    }
                    out.println();
                    cell3.hunting(cell3);
                    cell3.weightChecker(cell3);
                }
            }
        }

}
