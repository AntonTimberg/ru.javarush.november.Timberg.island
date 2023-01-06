package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.living_objects.LivingObject;

import java.util.ArrayList;

import static java.lang.System.out;
import static ru.javarush.november.timberg.island.field.IsleBoard.myIsle;

public class ShowInfo implements Runnable {

    @Override
    public void run() {
        monitor();
    }

    public void monitor() {
        //Cell[][] myIsleCopy = myIsle;
        out.println("|||||NEW CYCLE|||||");
        for (int i = 0; i < myIsle.length; i++) {
            for (int j = 0; j < myIsle[i].length; j++) {

                    myIsle[i][j].getLock();
                        try{
                            out.print((i + 1) + "/" + (j + 1) + " { ");
                            printCellInfo(myIsle[i][j].getCell());
                            out.println("}");
                        } finally {
                            myIsle[i][j].getLock().unlock();
                        }


            }
        }
    }

    public void printCellInfo(ArrayList cell) {
        ArrayList<Class> classArrayList = new ArrayList<>();
        for (Object animal : cell) {
            LivingObject object = (LivingObject) animal;
            int count = (int) cell.stream().filter(animal.getClass()::isInstance).count();
            if (!classArrayList.contains(animal.getClass())) System.out.print(object.getUnicode() + "=" + count + " ");
            classArrayList.add(animal.getClass());
        }
    }
}
