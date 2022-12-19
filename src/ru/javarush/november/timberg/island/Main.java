package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.Cell;
import ru.javarush.november.timberg.island.field.Isle;

public class Main {
    public static void main(String[] args) {
        Isle isle = new Isle();
        isle.isle_Creation();
        Cell cell = new Cell();
        for (int i = 0; i < 35; i++) {
            isle.isleWorking();
        }
   }
}