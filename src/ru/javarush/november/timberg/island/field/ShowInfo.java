package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.CellObject;

import java.util.ArrayList;

public class ShowInfo {
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
