package ru.javarush.november.timberg.island.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

public class Isle {
    public static Cell[][] MY_ISLE = new Cell[Config.ISLE_WIDTH][Config.ISLE_LENGTH];
    Cell cell = new Cell();
    Random random = new Random();

    public void isle_Creation() {
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
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

    public void isleWorking() {
        int y = 0;
        out.println();
        for (Cell[] cells : this.MY_ISLE) {
            y++;
            int x = 0;
            for (Cell cell3 : cells) {
                x++;
                out.println();
                out.print("Ячейка острова- " + y + " " + x + ":  ");
                for (Object object : cell3.getCell()) {
                    CellObject currentObject = (CellObject) object;
                    out.print(currentObject.toString());
                    out.print(":весом " + ((double) (Math.round(currentObject.getCurrentWeight() * 100)) / 100) + " кг.  ");
                }
                cell3.hunting(cell3);
                cell3.weightChecker(cell3);
                cell3.reproduction(cell3);
                cell3.grassGrowth(cell3);
                out.println();
                out.println("--------------------------------------");
            }
        }
        //movement();
    }

    public void movement(){
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
                ArrayList<Object> cellList = new ArrayList<>(MY_ISLE[i][j].getCell());
                int movement_speed = 0;
                for (Object o : cellList) {
                    CellObject animal = (CellObject) o;
                    movement_speed = (int) animal.getMaxSpeed();
                    chooseDirection(movement_speed,i,j,o);
                }
            }
        }
    }

    void chooseDirection(int movement_speed, int i, int j, Object o){
        int moveSpeed = 0;
        if (movement_speed > 0) moveSpeed = Math.abs(random.nextInt(movement_speed));

        int direction = Math.abs(random.nextInt(4));
        //out.println(" " + moveSpeed + " " +direction);
        CellObject cellObject = (CellObject) o;

        if (moveSpeed > 0){
            if (direction == 1 && MY_ISLE[i].length > j + moveSpeed ) {
                MY_ISLE[i][j].getCell().remove(o);
                out.print(cellObject.toString() + " уехал из " + i + " " + j + " ");
                MY_ISLE[i][j + moveSpeed].getCell().add(o);
                out.print(cellObject.toString() + " приехал в  " + i + " " + (j + moveSpeed) + " |...|");
            }

            if (direction == 2 && i - moveSpeed > 0) {
                MY_ISLE[i][j].getCell().remove(o);
                out.print(cellObject.toString() + " уехал из " + i + " " + j + " ");
                MY_ISLE[i - moveSpeed][j].getCell().add(o);
                out.print(cellObject.toString() + " приехал в  " + (i - moveSpeed) + " " + (j) + " |...|");
            }

            if (direction == 3 && j - moveSpeed > 0) {
                MY_ISLE[i][j].getCell().remove(o);
                out.print(cellObject.toString() + " уехал из " + i + " " + j + " ");
                MY_ISLE[i][j - moveSpeed].getCell().add(o);
                out.print(cellObject.toString() + " приехал в  " + i + " " + (j - moveSpeed) + " |...|");
            }

            if (direction == 4 && MY_ISLE.length > i + moveSpeed ) {
                MY_ISLE[i][j].getCell().remove(o);
                out.print(cellObject.toString() + " уехал из " + i + " " + j + " ");
                MY_ISLE[i + moveSpeed][j].getCell().add(o);
                out.print(cellObject.toString() + " приехал в  " + (i + moveSpeed) + " " + (j) + " |...|");
            }
        }
    }
}
