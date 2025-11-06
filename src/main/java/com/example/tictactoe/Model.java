package com.example.tictactoe;

public class Model {

    private char[][] feld = new char[3][3];
    private char[] spieler = new char[2];
    private int dran;
    private int zuege;

    public Model(char symbol1, char symbol2) {
        spieler[0] = symbol1;
        spieler[1] = symbol2;
        dran = 0;
        zuege = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                feld[i][j] = ' ';
            }
        }
    }

    public String aktuellerSpieler() {
        return String.valueOf(spieler[dran]);
    }

    public String getSymbol(int iRow, int iColumn) {
        return String.valueOf(feld[iRow][iColumn]);
    }

    public void zug(int iRow, int iColumn) {
        if (feld[iRow][iColumn] == ' ' && !hatGewonnen(spieler[0]) && !hatGewonnen(spieler[1])) {
            feld[iRow][iColumn] = spieler[dran];
            zuege++;
            if (!hatGewonnen(spieler[dran])) {
                dran = 1 - dran;
            }
        }
    }

    public String getGewinner() {
        if (hatGewonnen(spieler[0])) {
            return String.valueOf(spieler[0]);
        } else if (hatGewonnen(spieler[1])) {
            return String.valueOf(spieler[1]);
        }
        return null;
    }

    public boolean hatGewonnen(char symbol) {

        for (int i = 0; i < 3; i++) {
            if (feld[i][0] == symbol && feld[i][1] == symbol && feld[i][2] == symbol) return true;
        }

        for (int i = 0; i < 3; i++) {
            if (feld[0][i] == symbol && feld[1][i] == symbol && feld[2][i] == symbol) return true;
        }

        if (feld[0][0] == symbol && feld[1][1] == symbol && feld[2][2] == symbol) return true;
        if (feld[0][2] == symbol && feld[1][1] == symbol && feld[2][0] == symbol) return true;

        return false;
    }
}
