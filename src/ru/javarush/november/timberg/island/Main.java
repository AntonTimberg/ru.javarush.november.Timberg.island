package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.Cell;
import ru.javarush.november.timberg.island.field.CellObject;
import ru.javarush.november.timberg.island.field.Isle;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Isle isle = new Isle();
        isle.isle_Creation();
        Cell cell = new Cell();
//        int y = 0;
//        int x = 0;

//        for (Cell[] cells : isle.MY_ISLE) {
//            y++;
//            for (Cell cell : cells) {
//                x++;
//                out.println("Ячейка: " + y + " " + x);
//                out.println(cell.toString());
//            }
//            x = 0;
//        }

        for (Cell[] cells : isle.MY_ISLE) {
            for (Cell cell3 : cells) {
                out.println();
                for (Object object : cell3.getCell()) {
                    CellObject currentObject = (CellObject) object;
                    out.print(currentObject.toString());
                    out.print(":весом " + currentObject.getCurrentWeight() + " кг.  ");
                }
            }
        }

//        for (Cell[] cells : isle.MY_ISLE) {
//            for (Cell cell1 : cells) {
//                //ArrayList<Object> cell2 = ;
//                cell1.hunting(cell1.getCell());
//
//            }
//        }
//
//        for (Cell[] cells : isle.MY_ISLE) {
//            for (Cell cell3 : cells) {
//                out.println();
//                for (Object object : cell3.getCell()) {
//                    CellObject currentObject = (CellObject) object;
//                    out.print(currentObject.toString());
//                    out.print(":весом " + currentObject.getCurrentWeight() + " кг.  ");
//                }
//            }
//        }
   }
}