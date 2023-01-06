package ru.javarush.november.timberg.island.field;


public class IsleBoard {
    public static Cell[][] myIsle;

    public IsleBoard(int isleWidth, int isleLength) {
        myIsle = new Cell[isleWidth][isleLength];
        for (int i = 0; i < isleWidth; i++) {
            for (int j = 0; j < isleLength; j++) {
                myIsle[i][j] = new Cell();
                myIsle[i][j].createCell();
            }
        }
    }
}
