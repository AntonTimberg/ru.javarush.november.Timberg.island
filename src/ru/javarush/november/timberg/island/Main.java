package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.Cell;
import ru.javarush.november.timberg.island.field.Isle;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Isle isle = new Isle();
        isle.isle_Creation();
        Cell cell = new Cell();

        while (true) {
            System.out.println("|||||NEW CYCLE|||||");
            isle.isleWorking();
            System.out.println();
            isle.movement();
            TimeUnit.MILLISECONDS.sleep(4000);
        }
    }
}