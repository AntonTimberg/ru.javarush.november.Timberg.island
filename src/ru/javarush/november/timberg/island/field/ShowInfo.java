package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.CellObject;

import java.util.ArrayList;

import static java.lang.System.out;
import static ru.javarush.november.timberg.island.field.Isle.MY_ISLE;

public class ShowInfo {
    public void monitor() {
        for (int i = 0; i < MY_ISLE.length; i++) {
            for (int j = 0; j < MY_ISLE[i].length; j++) {
                out.print((i+1) + "/" + (j+1) + " { " );
                printCellInfo(MY_ISLE[i][j].getCell());
                out.println("}");
            }
        }
    }

    public void printCellInfo(ArrayList cell) {
        ArrayList<Class> classArrayList = new ArrayList<>();
        for (Object animal : cell) {
            CellObject object = (CellObject) animal;
            int count = (int) cell.stream().filter(animal.getClass()::isInstance).count();
            if (!classArrayList.contains(animal.getClass())) System.out.print(object.getUnicode() + "=" + count + " ");
            classArrayList.add(animal.getClass());
        }
    }
}
