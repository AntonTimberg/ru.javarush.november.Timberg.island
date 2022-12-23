package ru.javarush.november.timberg.island;

import ru.javarush.november.timberg.island.field.Isle;

import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Isle isle = new Isle();
        isle.isleCreation();

        while (true) {
            out.println("|||||NEW CYCLE|||||");
            isle.isleWorking();
            isle.monitor();
            TimeUnit.MILLISECONDS.sleep(2000);
        }
    }
}