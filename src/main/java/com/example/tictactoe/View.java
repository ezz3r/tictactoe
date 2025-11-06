package com.example.tictactoe;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View {

    private static final int GROESSE_FELD = 100;

    private Stage stage;
    private GridPane gridPane;
    private Button[][] buttons;
    private Model model;

    public View(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;
        this.buttons = new Button[3][3];
        this.gridPane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button("");
                button.setMinSize(GROESSE_FELD, GROESSE_FELD);
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe! - " + model.aktuellerSpieler() + " ist dran.");
        stage.show();
    }

    public void update() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(model.getSymbol(i, j));
            }
        }

        String winner = model.getGewinner();
        if (winner != null) {
            stage.setTitle("Tic Tac Toe! - Spieler " + winner + " hat gewonnen.");
        } else {
            stage.setTitle("Tic Tac Toe! - " + model.aktuellerSpieler() + " ist dran.");
        }
    }

    public Stage getStage() {
        return stage;
    }

    public Button getButton(int iRow, int iColumn) {
        return buttons[iRow][iColumn];
    }
}
